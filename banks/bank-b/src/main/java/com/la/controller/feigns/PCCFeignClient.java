package com.la.controller.feigns;


import com.la.model.dtos.PCCRequestDTO;
import com.la.model.dtos.PCCResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pcc")
public interface PCCFeignClient {

    @PostMapping(value = "/bank")
    PCCResponseDTO findIssuerBank(@RequestBody PCCRequestDTO pccRequestDTO);
}
