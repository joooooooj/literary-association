package com.la.service;

import com.la.dto.PaymentMethodsBuyerRequestDTO;
import com.la.model.BuyerRequest;

public interface BuyerRequestService {

    PaymentMethodsBuyerRequestDTO get(Long id);

}
