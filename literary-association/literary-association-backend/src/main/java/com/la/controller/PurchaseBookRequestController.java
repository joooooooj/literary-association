package com.la.controller;

import com.la.dto.PurchaseBookRequestDTO;
import com.la.service.PurchaseBookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/purchase-book")
public class PurchaseBookRequestController {

    @Autowired
    private PurchaseBookRequestService purchaseBookRequestService;

    @PostMapping(value = "")
    public ResponseEntity<?> createPurchaseRequest(@RequestBody PurchaseBookRequestDTO purchaseBookRequestDTO,
                                                   @RequestHeader("Authorization") String token) {
        try {
            purchaseBookRequestService.createPurchaseRequest(purchaseBookRequestDTO, token);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
