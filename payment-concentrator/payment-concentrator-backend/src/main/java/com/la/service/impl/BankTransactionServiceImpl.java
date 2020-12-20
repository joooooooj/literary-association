package com.la.service.impl;

import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.BuyerRequestDTO;
import com.la.model.Subscriber;
import com.la.model.SubscriberDetails;
import com.la.model.User;
import com.la.repository.SubscriberDetailsRepository;
import com.la.repository.TransactionRepository;
import com.la.repository.UserRepository;
import com.la.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriberDetailsRepository subscriberDetailsRepository;

    @Override // TO DO : Da li je pretplacen na banku
    public BankRequestDTO createBankRequestDTO(BuyerRequestDTO buyerRequestDTO) {
        Subscriber subscriber = (Subscriber) userRepository.findById(buyerRequestDTO.getSubscriberId()).get();
        SubscriberDetails subscriberDetails = subscriber.getSubscriberDetails();
        if(subscriberDetails != null){
            // TO DO : MAKE TRANSACTION OBJECT IN PC
            return new BankRequestDTO(subscriberDetails.getMerchantId(), subscriberDetails.getMerchantPassword(), buyerRequestDTO);
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
        // TO DO : UPDATE TRANSACTION STATUS AND RETURN STATUS URL
        return null;
    }
}
