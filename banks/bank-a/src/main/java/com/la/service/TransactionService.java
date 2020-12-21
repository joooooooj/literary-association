package com.la.service;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;

public interface TransactionService {

    BankPaymentUrlDTO createPayment(BankRequestDTO bankRequestDTO);

    BankResponseDTO createTransaction(TransactionFormDataDTO transactionFormDataDTO, Long paymentId);

}
