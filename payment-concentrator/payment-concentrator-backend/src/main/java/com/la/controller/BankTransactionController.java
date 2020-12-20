package com.la.controller;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import com.la.dto.BankResponseDTO;
import com.la.dto.BuyerRequestDTO;
import com.la.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("transaction")
public class BankTransactionController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private BankTransactionService transactionService;

    /**
     * POST transaction/
     *
     * Buyer from LA initiates making of new transaction
     *
     * @return bank payment form URL
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody BuyerRequestDTO buyerRequestDTO) {
        try {
            BankRequestDTO bankRequestDTO = transactionService.createBankRequestDTO(buyerRequestDTO);
            if (bankRequestDTO != null){
                // TO DO : If bank doesnt return form call LA to update order status to FAILED
                BankPaymentUrlDTO bankPaymentUrlDTO = getPaymentFormUrl(bankRequestDTO);
                // TO DO : If does update transaction payment ID in database
                transactionService.updateTransactionPaymentId(bankPaymentUrlDTO.getPaymentId());
                return new ResponseEntity<>(bankPaymentUrlDTO.getPaymentUrl(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * PUT transaction
     *
     * Bank returns payment status
     *
     * @return STATUS URL (SUCCESS, FAILED, ERROR)
     */
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody BankResponseDTO bankResponseDTO) {
        try {
            String statusUrl = transactionService.updateTransaction(bankResponseDTO);
            if (statusUrl != null){
                return new ResponseEntity<>(finishTransaction(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Calls bank service
     *
     * @return bank payment form URL and ID
     */
    private BankPaymentUrlDTO getPaymentFormUrl(BankRequestDTO bankRequestDTO) {
        BankPaymentUrlDTO response =
                restTemplate.exchange("http://banka-a/transaction",
                                        HttpMethod.POST,
                                        new HttpEntity<>(bankRequestDTO),
                                        new ParameterizedTypeReference<BankPaymentUrlDTO>() {})
                                        .getBody();

        return response;
    }

    /**
     * Calls literary assocciation service to update transaction status
     *
     * @return
     */
    private String finishTransaction() {
//        String response = restTemplate.exchange("http://localhost:8080/order/{merchantOrderId}",
//                HttpMethod.PUT, new HttpEntity<>(), new ParameterizedTypeReference<String>() {}).getBody();

        return "";
    }
}
