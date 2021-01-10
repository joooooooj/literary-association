package com.la.service.impl;

import com.la.dto.PurchaseBookRequestDTO;
import com.la.enumeration.TransactionStatus;
import com.la.mapper.PurchaseBookRequestDTOMapper;
import com.la.model.PurchaseBookRequest;
import com.la.model.Reader;
import com.la.model.User;
import com.la.repository.PurchaseBookRequestRepository;
import com.la.repository.ReaderRepository;
import com.la.repository.UserRepository;
import com.la.security.TokenUtils;
import com.la.service.PurchaseBookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class PurchaseBookRequestServiceImpl implements PurchaseBookRequestService {

    @Autowired
    private PurchaseBookRequestRepository purchaseBookRequestRepository;

    @Autowired
    private PurchaseBookRequestDTOMapper purchaseBookRequestDTOMapper;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public void createPurchaseRequest(PurchaseBookRequestDTO purchaseBookRequestDTO, String token) throws ParseException {
        Reader reader = (Reader) readerRepository.findByUsername(tokenUtils.getUsernameFromToken(token.substring(7)));
        if (reader == null) {
            throw new UsernameNotFoundException("User does not exist.");
        }

        PurchaseBookRequest request = purchaseBookRequestDTOMapper.toEntity(purchaseBookRequestDTO);
        request.setStatus(TransactionStatus.WAITING_PAYMENT);
        request.setReader(reader);
        purchaseBookRequestRepository.save(request);
    }
}
