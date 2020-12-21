package com.la.controller;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;
import com.la.model.Payment;
import com.la.model.Transaction;
import com.la.service.TransactionService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private TransactionService transactionService;

    /**
     * POST transaction/
     *
     * Payment Concetrator calls this endpoint to get bank payment url and id
     *
     * @return bank payment url and id object
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankPaymentUrlDTO> createPayment(@RequestBody BankRequestDTO bankRequestDTO) {
        try {
            // MAKE PAYMENT OBJECT AND GENERATE PAYMENT URL AND ID (SEND TO PAYMENT CONCETRATOR)
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            // e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * POST transaction/
     *
     * Buyer submits form
     *
     * @return HttpStatus
     */
    @PostMapping(value = "/{paymentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createTransaction(@RequestBody TransactionFormDataDTO transactionFormDataDTO, @PathVariable Long paymentId) {
        try {
            // WHEN TRANSACTION PROCESS DONE CALL PAYMENT CONCETRATOR TO UPDATE TRANSACTION
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Calls payment concetrator to update transaction status
     *
     * @return bank payment form URL
     */
    private String getPaymentFormUrl(BankResponseDTO bankResponseDTO) {
        String response =
                restTemplate.exchange("http://payment-concentrator/transaction",
                        HttpMethod.PUT,
                        new HttpEntity<>(bankResponseDTO),
                        new ParameterizedTypeReference<String>() {})
                        .getBody();

        return response;
    }
}
