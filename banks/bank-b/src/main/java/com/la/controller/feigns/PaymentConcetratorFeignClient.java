package com.la.controller.feigns;

import com.la.model.dtos.BankResponseDTO;
import com.la.model.dtos.UrlDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-api-gateway")
public interface PaymentConcetratorFeignClient {

    @PutMapping(value = "/api/auth/bank/transaction/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UrlDTO updateTransaction(@RequestBody BankResponseDTO bankResponseDTO);

}
