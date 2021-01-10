package com.la.service.impl;

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
    public BuyerRequest get(Long id){

        if(buyerRequestRepository.findById(id).isPresent()){
            return buyerRequestRepository.findById(id).get();
        }

        return null;
    }
}
