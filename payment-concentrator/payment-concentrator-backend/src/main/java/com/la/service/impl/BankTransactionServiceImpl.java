package com.la.service.impl;

import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.model.*;
import com.la.repository.*;
import com.la.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private BuyerRequestRepository buyerRequestRepository;

    @Override
    public BankRequestDTO createBankRequestDTO(Long buyerRequestId) {
        Optional<BuyerRequest> buyerRequest = buyerRequestRepository.findById(buyerRequestId);
        if (buyerRequest.isPresent()){
            SubscriberDetails subscriberDetails = buyerRequest.get().getSubscriber().getSubscriberDetails();
            if(subscriberDetails != null){
                Transaction transaction = new Transaction();
                transaction.setStatus(Status.PENDING);
                transaction.setBuyerRequest(buyerRequest.get());
                transaction.setPaymentMethod(paymentMethodRepository.findByName("Bank"));
                transactionRepository.save(transaction);
                return new BankRequestDTO(subscriberDetails.getMerchantId(),
                                        subscriberDetails.getMerchantPassword(),
                                        buyerRequest.get().getAmount(),
                                        buyerRequest.get().getMerchantTimestamp(),
                                        buyerRequest.get().getMerchantOrderId());
            }
            return null;
        }
        return null;
    }

    @Override
    public void updateTransactionPaymentId(Long paymentId, Long buyerRequestId) {
        Transaction transaction = transactionRepository.findByBuyerRequest(buyerRequestRepository.findById(buyerRequestId).get());
        transaction.setPaymentId(paymentId);
        transactionRepository.save(transaction);
    }

    @Override
    public String updateTransactionError(Long buyerRequestId) {
        Transaction transaction = transactionRepository.findByBuyerRequest(buyerRequestRepository.findById(buyerRequestId).get());
        transaction.setStatus(Status.ERROR);
        transactionRepository.save(transaction);

        return transaction.getBuyerRequest().getSubscriber().getSubscriberDetails().getErrorUrl();
    }

    @Override
    public String updateTransaction(BankResponseDTO bankResponseDTO) {
        // TO DO : UPDATE TRANSACTION STATUS AND RETURN STATUS URL
        return null;
    }
}
