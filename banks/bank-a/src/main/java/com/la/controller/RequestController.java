package com.la.controller;

import com.la.model.Payment;
import com.la.model.Transaction;
import com.la.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("")
    public ResponseEntity<Payment> transactionRequest(@RequestBody Transaction transaction) {
        try {
            Payment payment = this.requestService.transactionRequest(transaction);
            return new ResponseEntity<>(payment, HttpStatus.CREATED);
        } catch (Exception e) {
            // e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
