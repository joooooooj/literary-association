package com.la.service;

import com.la.dto.PurchaseBookRequestDTO;

import java.text.ParseException;

public interface PurchaseBookRequestService {
    void createPurchaseRequest(PurchaseBookRequestDTO purchaseBookRequestDTO, String token) throws ParseException;
}
