package com.la.controller;

import com.la.mapper.PaymentMethodDTOMapper;
import com.la.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private PaymentMethodDTOMapper mapper;


}
