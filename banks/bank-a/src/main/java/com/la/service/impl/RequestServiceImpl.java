package com.la.service.impl;

import com.la.model.Payment;
import com.la.model.Transaction;
import com.la.repository.TransactionRepository;
import com.la.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Payment transactionRequest(Transaction transaction) {
        this.transactionRepository.save(transaction);
        Payment payment = new Payment();
        return payment;
    }
}
