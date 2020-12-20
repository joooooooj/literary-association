package com.la.service.impl;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;
import com.la.repository.AccountRepository;
import com.la.repository.CardRepository;
import com.la.repository.PaymentRepository;
import com.la.repository.TransactionRepository;
import com.la.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;

    public BankPaymentUrlDTO createPayment(BankRequestDTO bankRequestDTO) {
        // TO DO : Check if merchant id exists
        // If exists create Payment object in database
        // Create nedeed DTO and return
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
