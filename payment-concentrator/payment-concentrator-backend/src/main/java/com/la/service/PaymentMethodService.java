package com.la.service;

import com.la.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> getAll();

    List<PaymentMethod> getAllWithoutFirstThree();
}
