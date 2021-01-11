package com.pcc.service.impl;

import com.pcc.dto.PCCRequestDTO;
import com.pcc.repository.BankRepository;
import com.pcc.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void findIssuerBank(PCCRequestDTO pccRequestDTO) {
        String pan = pccRequestDTO.getPan().substring(0,2);
        switch (this.bankRepository.findBankByPan(pan).getName()) {
            case "bank-a": break;
            case "bank-b": break;
            default: ;
        }

    }
}
