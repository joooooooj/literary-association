package com.la.service.impl;

import com.la.dto.CreatedBookPurchaseRequestDTO;
import com.la.dto.PurchaseBookRequestDTO;
import com.la.enumeration.TransactionStatus;
import com.la.feignClients.PaymentConcentratorFeignClient;
import com.la.mapper.PurchaseBookRequestDTOMapper;
import com.la.model.PurchaseBookRequest;
import com.la.model.Reader;
import com.la.repository.PurchaseBookRequestRepository;
import com.la.repository.ReaderRepository;
import com.la.security.TokenUtils;
import com.la.security.UserTokenState;
import com.la.security.auth.JwtAuthenticationRequest;
import com.la.service.PurchaseBookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;

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

    @Autowired
    private PaymentConcentratorFeignClient feignClient;

    @Override
    public CreatedBookPurchaseRequestDTO createPurchaseRequest(PurchaseBookRequestDTO purchaseBookRequestDTO) throws ParseException {
//        Reader reader = (Reader) readerRepository.findByUsername(tokenUtils.getUsernameFromToken(token.substring(7)));

        PurchaseBookRequest request = purchaseBookRequestDTOMapper.toEntity(purchaseBookRequestDTO);
        request.setStatus(TransactionStatus.WAITING_PAYMENT);
//        request.setReader(reader);
        purchaseBookRequestRepository.saveAndFlush(request);

        UserTokenState userTokenState = feignClient.login(new JwtAuthenticationRequest("vulkan", "123123"));

        return new CreatedBookPurchaseRequestDTO(request.getId(), LocalDateTime.now().toString(), request.getPrice(),
                userTokenState.getAccessToken(), tokenUtils.getUsernameFromToken(userTokenState.getAccessToken()));
    }
}
