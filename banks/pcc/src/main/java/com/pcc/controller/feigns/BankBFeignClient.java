package com.pcc.controller.feigns;

import com.pcc.model.dtos.PCCRequestDTO;
import com.pcc.model.dtos.PCCResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-b")
public interface BankBFeignClient {

    @PostMapping(value = "/transaction/second")
    PCCResponseDTO createSecondTransaction(@RequestBody PCCRequestDTO pccRequestDTO);
}
