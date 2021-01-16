package com.la.service.impl;

import com.la.model.Book;
import com.la.model.dtos.CreatedBookPurchaseRequestDTO;
import com.la.model.dtos.PurchaseBookRequestDTO;
import com.la.model.enums.TransactionStatus;
import com.la.controller.feigns.PaymentConcentratorFeignClient;
import com.la.model.PurchaseBookRequest;
import com.la.repository.BookRepository;
import com.la.repository.PurchaseBookRequestRepository;
import com.la.security.TokenUtils;
import com.la.security.UserTokenState;
import com.la.security.auth.JwtAuthenticationRequest;
import com.la.service.PurchaseBookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseBookRequestServiceImpl implements PurchaseBookRequestService {

    @Autowired
    private PurchaseBookRequestRepository purchaseBookRequestRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PaymentConcentratorFeignClient feignClient;

    @Value("${pc.username}")
    private String username;

    @Value("${pc.password}")
    private String password;

    @Override
    public CreatedBookPurchaseRequestDTO createPurchaseRequest(PurchaseBookRequestDTO purchaseBookRequestDTO) throws ParseException {
        // TO DO SET READER IF USER LOGGED IN
        //  Reader reader = (Reader) readerRepository.findByUsername(tokenUtils.getUsernameFromToken(token.substring(7)));

        PurchaseBookRequest request = new PurchaseBookRequest();
        request.setStatus(TransactionStatus.WAITING_PAYMENT);
        request.setAmount(purchaseBookRequestDTO.getAmount());
        System.err.println(purchaseBookRequestDTO.getBookList());
        List<Book> bookList = new ArrayList<>();
        for(Long id : purchaseBookRequestDTO.getBookList()){
            if(bookRepository.findById(id).isPresent()){
                bookList.add(bookRepository.findById(id).get());
            }
        }
        request.setBookList(bookList);
        System.err.println(bookList);
        // request.setReader(reader);
        purchaseBookRequestRepository.saveAndFlush(request);

        UserTokenState userTokenState = feignClient.login(new JwtAuthenticationRequest(username, password));

        return new CreatedBookPurchaseRequestDTO(request.getId(), LocalDateTime.now(), request.getAmount(),
                userTokenState.getAccessToken(), tokenUtils.getUsernameFromToken(userTokenState.getAccessToken()));
    }
}
