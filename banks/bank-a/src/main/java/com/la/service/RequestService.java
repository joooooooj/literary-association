package com.la.service;

import com.la.model.Payment;
import com.la.model.Transaction;

public interface RequestService {
    Payment transactionRequest(Transaction transaction);
}
