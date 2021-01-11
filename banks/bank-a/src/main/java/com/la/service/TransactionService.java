package com.la.service;

import com.la.model.dtos.BankPaymentUrlDTO;
import com.la.model.dtos.BankRequestDTO;
import com.la.model.dtos.BankResponseDTO;
import com.la.model.dtos.TransactionFormDataDTO;
import com.la.model.Payment;

public interface TransactionService {

    BankPaymentUrlDTO createPayment(BankRequestDTO bankRequestDTO);

    BankResponseDTO createTransaction(TransactionFormDataDTO transactionFormDataDTO, Long paymentId);

    Payment getPayment(Long paymentId);
}
