package com.la.service.impl;

import com.la.dto.BuyerRequestDTO;
import com.la.dto.PaymentMethodsBuyerRequestDTO;
import com.la.model.BuyerRequest;
import com.la.repository.BuyerRequestRepository;
import com.la.service.BuyerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerRequestServiceImpl implements BuyerRequestService {

    @Autowired
    private BuyerRequestRepository buyerRequestRepository;

    @Override
    public PaymentMethodsBuyerRequestDTO get(Long id){

        if(buyerRequestRepository.findById(id).isPresent()){
            BuyerRequest buyerRequest =  buyerRequestRepository.findById(id).get();

            PaymentMethodsBuyerRequestDTO paymentMethodsBuyerRequestDTO = new PaymentMethodsBuyerRequestDTO();

            paymentMethodsBuyerRequestDTO.setPaymentMethods(buyerRequest.getSubscriber().getPaymentMethods());
            paymentMethodsBuyerRequestDTO.setUsername(buyerRequest.getSubscriber().getUsername());

            BuyerRequestDTO buyerRequestDTO = new BuyerRequestDTO();
            buyerRequestDTO.setAmount(buyerRequest.getAmount());
            buyerRequestDTO.setMerchantOrderId(buyerRequest.getId());

            paymentMethodsBuyerRequestDTO.setBuyerRequestDTO(buyerRequestDTO);

            return paymentMethodsBuyerRequestDTO;
        }

        return null;
    }
}
