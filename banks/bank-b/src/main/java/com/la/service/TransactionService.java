package com.la.service;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;
import com.la.model.Payment;

public interface TransactionService {

    BankPaymentUrlDTO createPayment(BankRequestDTO bankRequestDTO);

    BankResponseDTO createTransaction(TransactionFormDataDTO transactionFormDataDTO, Long paymentId);

    Payment getPayment(Long paymentId);
}
