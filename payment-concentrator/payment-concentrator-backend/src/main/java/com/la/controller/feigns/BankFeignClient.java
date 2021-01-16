package com.la.controller.feigns;

import com.la.model.dtos.bank.BankPaymentUrlDTO;
import com.la.model.dtos.bank.BankRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-a")
public interface BankFeignClient {

    @PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BankPaymentUrlDTO getPaymentUrlDTO(@RequestBody BankRequestDTO bankRequestDTO);

}
