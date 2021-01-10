package com.la.service.impl;

import com.la.dto.PurchaseBookRequestDTO;
import com.la.repository.PurchaseBookRequestRepository;
import com.la.service.PurchaseBookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseBookRequestServiceImpl implements PurchaseBookRequestService {

    @Autowired
    private PurchaseBookRequestRepository purchaseBookRequestRepository;

    @Override
    public void createPurchaseRequest(PurchaseBookRequestDTO purchaseBookRequestDTO) {

    }
}
