package com.la.controller;

import com.la.dto.*;
import com.la.dto.bank.BankPaymentUrlDTO;
import com.la.dto.bank.BankRequestDTO;
import com.la.dto.bank.BankResponseDTO;
import com.la.feign.BankFeignClient;
import com.la.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class BankTransactionController {

    @Autowired
    private BankTransactionService transactionService;

    @Autowired
    private BankFeignClient bankFeignClient;

    /**
     * POST transaction/
     *
     * Buyer from LA initiates making of new transaction
     *
     * @return bank payment form URL
     */
    @PreAuthorize("hasAuthority('INITIATE_PAYMENT')")
    @PostMapping(value = "/{buyerRequestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@PathVariable Long buyerRequestId) {
        try {
            BankRequestDTO bankRequestDTO = transactionService.createBankRequestDTO(buyerRequestId);
            System.err.println(bankRequestDTO);
            if (bankRequestDTO != null){
                    // If does update transaction payment ID in database
                    // If bank doesnt return form call LA to update order status to FAILED
                    BankPaymentUrlDTO bankPaymentUrlDTO = getPaymentFormUrl(bankRequestDTO);
                    if (bankPaymentUrlDTO != null) {
                        transactionService.updateTransactionPaymentId(bankPaymentUrlDTO.getPaymentId(), buyerRequestId);
                        return new ResponseEntity<>(bankPaymentUrlDTO.getPaymentUrl(), HttpStatus.OK);
                    }
                    String errorUrl = transactionService.updateTransactionError(buyerRequestId);
//                  finishTransaction(new SubscriberUpdateTransactionDTO(bankRequestDTO.getMerchantOrderId(), Status.FAILED));

                    return new ResponseEntity<>(errorUrl, HttpStatus.PRECONDITION_FAILED);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody BankResponseDTO bankResponseDTO) {
        try {
            String statusUrl = transactionService.updateTransaction(bankResponseDTO);
//            finishTransaction(new SubscriberUpdateTransactionDTO(bankResponseDTO.getMerchantOrderId(), bankResponseDTO.getStatus()));
            if (statusUrl != null){
                return new ResponseEntity<>(statusUrl, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Calls bank service
     *
     * @return bank payment form URL and ID
     */
    private BankPaymentUrlDTO getPaymentFormUrl(BankRequestDTO bankRequestDTO) {
        return bankFeignClient.getPaymentUrlDTO(bankRequestDTO);
    }

    /**
     * Calls literary assocciation service to update transaction status
     *
     * @return
     */
    private String finishTransaction(SubscriberUpdateTransactionDTO subscriberUpdateTransactionDTO) {
//        String response = restTemplate.exchange("http://localhost:8080/order/{merchantOrderId}",
//                HttpMethod.PUT, new HttpEntity<>(), new ParameterizedTypeReference<String>() {}).getBody();
        // NEED FEIGN CLIENT

        return "";
    }
}
