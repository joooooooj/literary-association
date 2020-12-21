package com.la.feign;

import com.la.dto.BankPaymentUrlDTO;
import com.la.dto.BankRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-a")
public interface BankFeignClient {

    @PostMapping(value = "/transaction")
    BankPaymentUrlDTO getPaymentUrlDTO(@RequestBody BankRequestDTO bankRequestDTO);

}
