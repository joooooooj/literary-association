package com.la.service.impl;

import com.la.model.PaymentMethod;
import com.la.repository.PaymentMethodRepository;
import com.la.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public List<PaymentMethod> getAllWithoutFirstThree() {
        return paymentMethodRepository.getAllWithoutFirstThree();
    }
}
