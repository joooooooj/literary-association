package com.la.controller;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.TransactionFormDataDTO;
import com.la.model.Client;
import com.la.model.Status;
import com.la.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(value = "http://localhost:3002")
@RequestMapping(value = "/transaction")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

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
     * @return STATUS URL WHICH PAYMENT CONCETRATOR RETURNS
     */
    @PostMapping(value = "/{paymentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTransaction(@RequestBody TransactionFormDataDTO transactionFormDataDTO, @PathVariable Long paymentId) {
        try {
            BankResponseDTO bankResponseDTO = this.transactionService.createTransaction(transactionFormDataDTO, paymentId);
            if (bankResponseDTO.getStatus().equals(Status.ERROR)) {
                logger.warn("Date : {}, Wrong user input while paying with bank card. " +
                        "Warn : {}.", LocalDateTime.now(), "Bank transaction error");
            } else if (bankResponseDTO.getStatus().equals(Status.FAILED)) {
                logger.warn("Date : {}, Not enough money in user's bank account. " +
                        "Warn : {}.", LocalDateTime.now(), "Bank transaction failed");
            } else {
                logger.info("Date : {}, Bank payment successful. " +
                        "Info : {}.", LocalDateTime.now(), "Successful bank transaction");
            }
            // WHEN TRANSACTION PROCESS DONE CALL PAYMENT CONCETRATOR TO UPDATE TRANSACTION AND GET STATUS URL
            //this.getPaymentFormUrl(bankResponseDTO)
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Date : {}, Error while paying with bank card. " +
                    "Error : {}.", LocalDateTime.now(), e.toString());

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Calls payment concetrator to update transaction status
     *
     * @return STATUS URL (SUCCESS, FAILED, ERROR)
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
