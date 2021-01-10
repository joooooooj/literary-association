package com.la.controller;

import com.la.model.OrderRequest;
import com.la.model.OrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping(value = "")
    public ResponseEntity<OrderResult> create(@RequestBody OrderRequest orderRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth("CbPskEJ6SFqkZcLNLHPCMmuue8tzbtaJTXsUCBG7");

        HttpEntity<OrderRequest> body = new HttpEntity<>(orderRequest, headers);

        OrderResult orderResult = restTemplate.exchange("https://api-sandbox.coingate.com/v2/orders",
                HttpMethod.POST, body, new ParameterizedTypeReference<OrderResult>() {}).getBody();

        return new ResponseEntity<>(orderResult, HttpStatus.OK);
    }

}
