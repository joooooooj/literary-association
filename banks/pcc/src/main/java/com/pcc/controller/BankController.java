package com.pcc.controller;

import com.pcc.dto.PCCRequestDTO;
import com.pcc.dto.PCCResponseDTO;
import com.pcc.model.Status;
import com.pcc.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping(value = "")
    public PCCResponseDTO findIssuerBank(@RequestBody PCCRequestDTO pccRequestDTO) {
        this.bankService.findIssuerBank(pccRequestDTO);
        return new PCCResponseDTO(pccRequestDTO.getAcquirerOrderId(), pccRequestDTO.getAcquirerTimestamp(), 1L, LocalDateTime.now(), Status.SUCCESS);
    }
}
