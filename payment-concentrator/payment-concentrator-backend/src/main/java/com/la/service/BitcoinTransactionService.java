package com.la.service;

import com.la.dto.bitcoin.OrderRequest;
import com.la.dto.bitcoin.OrderResult;

public interface BitcoinTransactionService {

    OrderRequest createOrderRequest(Long buyerRequestId);

    void updateTransaction(OrderResult orderResult);
}
