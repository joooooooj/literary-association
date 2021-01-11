package com.la.feign;

import com.la.dto.PCCRequestDTO;
import com.la.dto.PCCResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pcc")
public interface PCCFeignClient {

    @PostMapping(value = "/bank")
    PCCResponseDTO findIssuerBank(@RequestBody PCCRequestDTO pccRequestDTO);
}
