package com.la.service.impl;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;
import com.la.model.Payment;
import com.la.model.*;
import com.la.repository.*;
import com.la.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.OperationsException;
import javax.validation.ValidationException;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public BankPaymentUrlDTO createPayment(BankRequestDTO bankRequestDTO) {
        // Check if merchant id exists
        // If exists create Payment object in database
        // Create nedeed DTO and return

        // COMPARE PASSWORDS???

        if(merchantRepository.findById(bankRequestDTO.getMerchantId()).isPresent()){
            Payment payment = new Payment();
            payment.setMerchantTimestamp(bankRequestDTO.getMerchantTimestamp());
            payment.setAmount(bankRequestDTO.getAmount());
            payment.setMerchantOrderId(bankRequestDTO.getMerchantOrderId());
            payment.setMerchant(merchantRepository.getOne(bankRequestDTO.getMerchantId()));
            payment = paymentRepository.save(payment);

            return new BankPaymentUrlDTO(payment.getId(), "http://localhost:8084/form/" + payment.getId());
        }

        return null;
    }

    public BankResponseDTO createTransaction(TransactionFormDataDTO transactionFormDataDTO, Long paymentId) {
        Payment payment = new Payment();
        Account account = new Account();
        Transaction transaction = new Transaction();
        try {
            boolean valid = false;
            payment = this.paymentRepository.findOneById(paymentId);
            if (payment.equals(null)) {
                throw new NullPointerException();
            }
            if (!transactionFormDataDTO.getPan().matches("^[0-9]*$") || transactionFormDataDTO.getPan().length() < 14 || transactionFormDataDTO.getPan().length() > 16 ) {
                throw new ValidationException();
            }
            if (!transactionFormDataDTO.getSecurityCode().matches("^[0-9]*$") || transactionFormDataDTO.getSecurityCode().length() < 3 || transactionFormDataDTO.getSecurityCode().length() > 4) {
                throw new ValidationException();
            }
            String[] cardholder = transactionFormDataDTO.getCardholderName().split(" ");
            String name = cardholder[0];
            String surname = cardholder[1];
            Client client = clientRepository.findByNameAndSurname(name, surname);
            if (client != null) {
                account = (cardRepository.findByPanAndSecurityCodeAndExpireDate(transactionFormDataDTO.getPan(),transactionFormDataDTO.getSecurityCode(),transactionFormDataDTO.getExpireDate())).getAccount();

                if (account.getBalance() < payment.getAmount()) {
                    throw new OperationsException();
                }

                account.setBalance(account.getBalance() - payment.getAmount());
                this.accountRepository.save(account);

                Account merchantAccount = payment.getMerchant().getAccount();
                merchantAccount.setBalance(merchantAccount.getBalance() + payment.getAmount());
                this.accountRepository.save(merchantAccount);

                transaction.setAccount(account);
                transaction.setPayment(payment);
                transaction.setStatus(Status.SUCCESS);
                transaction.setIssuerOrderId(null);
                transaction.setIssuerTimestamp(null);
                transaction.setTimestamp(LocalDateTime.now());
                transactionRepository.save(transaction);
            }
            else {
                throw new ValidationException();
            }
        } catch (OperationsException e) {
            transaction.setAccount(account);
            transaction.setPayment(payment);
            transaction.setStatus(Status.FAILED);
            transaction.setIssuerOrderId(null);
            transaction.setIssuerTimestamp(null);
            transaction.setTimestamp(LocalDateTime.now());
            transactionRepository.save(transaction);
            return new BankResponseDTO(payment.getMerchantOrderId(), transaction.getId(),
                    transaction.getTimestamp(),paymentId, Status.FAILED);
        } catch (ValidationException | IndexOutOfBoundsException e) {
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setStatus(Status.ERROR);
            transaction.setPayment(payment);
            transaction.setIssuerTimestamp(null);
            transaction.setIssuerOrderId(null);
            transactionRepository.save(transaction);
            return new BankResponseDTO(payment.getMerchantOrderId(), transaction.getId(),
                    transaction.getTimestamp(),paymentId, Status.ERROR);
        } catch (Exception e) {
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setStatus(Status.ERROR);
            transactionRepository.save(transaction);
            return new BankResponseDTO(null, transaction.getId(),
                    transaction.getTimestamp(),paymentId, Status.ERROR);
        }
        return new BankResponseDTO(payment.getMerchantOrderId(), transaction.getId(),
                transaction.getTimestamp(),paymentId, Status.SUCCESS);
    }

}
