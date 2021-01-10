package com.la.service;

import com.la.dto.CreatedBookPurchaseRequestDTO;
import com.la.dto.PurchaseBookRequestDTO;

import java.text.ParseException;

public interface PurchaseBookRequestService {
    CreatedBookPurchaseRequestDTO createPurchaseRequest(PurchaseBookRequestDTO purchaseBookRequestDTO, String token) throws ParseException;
}
