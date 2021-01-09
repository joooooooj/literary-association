package com.la.service;

import com.la.dto.BuyerRequestDTO;
import com.la.dto.PaymentMethodDTO;
import com.la.dto.PaymentMethodsBuyerRequestDTO;
import com.la.model.PaymentMethod;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface PaymentMethodService {
    List<PaymentMethod> getAll();

    List<PaymentMethod> getAllWithoutFirstThree();

    Long createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws ParseException, NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    boolean deletePaymentMethod(Long paymentMethodId);

    String getPaymentMethodsUrl(BuyerRequestDTO buyerRequestDTO, String username);
}