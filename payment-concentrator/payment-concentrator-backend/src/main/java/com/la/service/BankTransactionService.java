package com.la.service;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.BuyerRequestDTO;

public interface BankTransactionService {

    BankRequestDTO createBankRequestDTO(BuyerRequestDTO buyerRequestDTO);

    String updateTransaction(BankResponseDTO bankResponseDTO);

    String updateTransactionPaymentId(Long paymentId);

}
