package com.la.service;

import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;

import java.util.List;

public interface BankTransactionService {

    BankRequestDTO createBankRequestDTO(Long paymentId);

    String updateTransaction(BankResponseDTO bankResponseDTO);

    String updateTransactionError(Long buyerRequestId);

    void updateTransactionPaymentId(Long paymentId, Long buyerRequestId);

}
