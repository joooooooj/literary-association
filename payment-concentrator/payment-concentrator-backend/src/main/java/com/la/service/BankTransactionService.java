package com.la.service;

import com.la.model.dtos.bank.BankRequestDTO;
import com.la.model.dtos.bank.BankResponseDTO;

public interface BankTransactionService {

    BankRequestDTO createBankRequestDTO(Long paymentId);

    String updateTransaction(BankResponseDTO bankResponseDTO);

    String updateTransactionError(Long buyerRequestId);

    void updateTransactionPaymentId(Long paymentId, Long buyerRequestId);

}
