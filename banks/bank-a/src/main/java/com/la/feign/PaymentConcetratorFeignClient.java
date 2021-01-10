package com.la.feign;

import com.la.dto.BankResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "zuul-api-gateway")
public interface PaymentConcetratorFeignClient {

    @PutMapping(value = "/transaction/update")
    String updateTransaction(@RequestBody BankResponseDTO bankResponseDTO);

}
