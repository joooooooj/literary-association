package com.la.service;

import com.la.dto.SubscriptionRequestDTO;

import java.text.ParseException;

public interface SubscriptionRequestService {
    Long createRequest(SubscriptionRequestDTO requestDTO) throws ParseException;

    void approveRequest(Long requestId);

    Boolean declineRequest(Long requestId);
}
