package com.pcc.service.impl;

import com.pcc.controller.feigns.BankAFeignClient;
import com.pcc.controller.feigns.BankBFeignClient;
import com.pcc.model.dtos.PCCRequestDTO;
import com.pcc.model.dtos.PCCResponseDTO;
import com.pcc.model.enums.Status;
import com.pcc.repository.BankRepository;
import com.pcc.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BankAFeignClient bankAFeignClient;

    @Autowired
    private BankBFeignClient bankBFeignClient;

    @Override
    public PCCResponseDTO findIssuerBank(PCCRequestDTO pccRequestDTO) {
        String pan = pccRequestDTO.getPan().substring(0,3);
        try {
            switch (this.bankRepository.findBankByPan(pan).getName()) {
                case "bank-a":
                    return this.bankAFeignClient.createSecondTransaction(pccRequestDTO);
                case "bank-b":
                    return this.bankBFeignClient.createSecondTransaction(pccRequestDTO);
                default:
                    return new PCCResponseDTO(pccRequestDTO.getAcquirerOrderId(), pccRequestDTO.getAcquirerTimestamp(), null, null, Status.ERROR);
            }
        } catch (NullPointerException e) {
            return new PCCResponseDTO(pccRequestDTO.getAcquirerOrderId(), pccRequestDTO.getAcquirerTimestamp(), null, null, Status.ERROR);
        }
    }
}
