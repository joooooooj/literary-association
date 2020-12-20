package com.la.service.impl;

import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.BuyerRequestDTO;
import com.la.model.SubscriberDetails;
import com.la.repository.SubscriberDetailsRepository;
import com.la.repository.TransactionRepository;
import com.la.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SubscriberDetailsRepository subscriberDetailsRepository;

    @Override
    public BankRequestDTO createBankRequestDTO(BuyerRequestDTO buyerRequestDTO) {
        SubscriberDetails subscriberDetails = subscriberDetailsRepository.findById(buyerRequestDTO.getSubscriberId()).get();
        if(subscriberDetails != null){
            // TO DO : MAKE TRANSACTION OBJECT
            return new BankRequestDTO(subscriberDetails.getMerchantPassword(), buyerRequestDTO);
        }
        return null;
    }

    @Override
    public String updateTransactionPaymentId(Long paymentId) {
        // TO DO : UPDATE PAYMENT ID
        return null;
    }

    @Override
    public String updateTransaction(BankResponseDTO bankResponseDTO) {
        // TO DO : UPDATE TRANSACTION STATUS
        return null;
    }
}
