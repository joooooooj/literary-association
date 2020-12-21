package com.la.service.impl;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;
import com.la.model.Merchant;
import com.la.model.Payment;
import com.la.repository.*;
import com.la.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    PaymentRepository paymentRepository;

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
        // TO DO :
        // Validate paymentId
        // Check transaction form data (validate) and check account balance
        // Card holder data check in client table (name and surname)
        // Create transaction object
        // Update account balance both for buyer and merchant
        // Create and return BankResponseDTO

        return null;
    }

}
