package com.la.service;

import com.la.dto.bank.BankRequestDTO;
import com.la.dto.bank.BankResponseDTO;

public interface BankTransactionService {

    BankRequestDTO createBankRequestDTO(Long paymentId);

    String updateTransaction(BankResponseDTO bankResponseDTO);

    String updateTransactionError(Long buyerRequestId);

    void updateTransactionPaymentId(Long paymentId, Long buyerRequestId);

}
