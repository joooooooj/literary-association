package com.la.controller;

import com.la.dto.PaymentMethodDTO;
import com.la.mapper.PaymentMethodDTOMapper;
import com.la.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/auth/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private PaymentMethodDTOMapper mapper;

    @GetMapping(value = "")
    public ResponseEntity<List<PaymentMethodDTO>> getAll() {
        try {
            return new ResponseEntity<>(paymentMethodService.getAll().stream().map(mapper::toDto)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/other")
    public ResponseEntity<List<PaymentMethodDTO>> getAllWithoutFirstThree() {
        try {
            return new ResponseEntity<>(paymentMethodService.getAllWithoutFirstThree().stream().map(mapper::toDto)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
