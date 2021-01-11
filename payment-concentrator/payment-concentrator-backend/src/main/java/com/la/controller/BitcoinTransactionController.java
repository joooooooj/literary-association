package com.la.controller;

import com.la.dto.UrlDTO;
import com.la.dto.bitcoin.OrderRequest;
import com.la.dto.bitcoin.OrderResult;
import com.la.service.BitcoinTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping(value = "/api/auth/bitcoin/transaction")
public class BitcoinTransactionController {

    @Autowired
    private BitcoinTransactionService bitcoinTransactionService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/{buyerRequestId}")
    public ResponseEntity<UrlDTO> getBitcoinPaymentUrl(@PathVariable Long buyerRequestId){
        UrlDTO urlDTO = new UrlDTO();
        try{
            OrderRequest orderRequest = bitcoinTransactionService.createOrderRequest(buyerRequestId);
            OrderResult orderResult = getBitcoinPaymentUrl(orderRequest);

            System.err.println(orderResult.getPayment_url());

            bitcoinTransactionService.updateTransaction(orderResult);
            urlDTO.setUrl(orderResult.getPayment_url());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(urlDTO, HttpStatus.OK);
    }

    private OrderResult getBitcoinPaymentUrl(OrderRequest orderRequest){
        OrderResult orderResult = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<OrderRequest> body = new HttpEntity<>(orderRequest, headers);

            orderResult = restTemplate.exchange("http://bitcoin/order",
                    HttpMethod.POST, body, new ParameterizedTypeReference<OrderResult>() {}).getBody();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return orderResult;
    }
}
