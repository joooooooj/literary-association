package com.la.service;

import com.la.model.dtos.SubscriptionRequestDTO;
import com.la.model.SubscriptionRequest;

import java.text.ParseException;
import java.util.List;

public interface SubscriptionRequestService {
    List<SubscriptionRequest> getAll();

    Long createRequest(SubscriptionRequestDTO requestDTO) throws ParseException;

    void approveRequest(Long requestId);

    Boolean declineRequest(Long requestId);
}
