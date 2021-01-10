package com.la.controller;

import com.la.dto.BuyerRequestDTO;
import com.la.dto.PaymentMethodDTO;
import com.la.dto.PaymentMethodsBuyerRequestDTO;
import com.la.mapper.PaymentMethodDTOMapper;
import com.la.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private PaymentMethodDTOMapper mapper;

    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_PAYMENT_METHOD')")
    public ResponseEntity<Long> createPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        try {
            return new ResponseEntity<>(paymentMethodService.createPaymentMethod(paymentMethodDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            // e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('DELETE_PAYMENT_METHOD')")
    public ResponseEntity<Boolean> deletePaymentMethod(@PathVariable("id") Long paymentMethodId) {
        try {
            return new ResponseEntity<>(paymentMethodService.deletePaymentMethod(paymentMethodId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Return URL to LA to choose payment method
    @PostMapping(value = "subscriber/{username}")
    @PreAuthorize("hasAuthority('INITIATE_PAYMENT')")
    public ResponseEntity<String> getPaymentMethodsUrl(@RequestBody BuyerRequestDTO buyerRequestDTO, @PathVariable String username) {
        try {
            return new ResponseEntity<>(paymentMethodService.getPaymentMethodsUrl(buyerRequestDTO, username), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
