package com.la.scheduling;

import com.la.dto.bitcoin.OrderResult;
import com.la.model.Status;
import com.la.model.Transaction;
import com.la.repository.PaymentMethodRepository;
import com.la.repository.TransactionRepository;
import com.la.service.BitcoinTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Component
public class UpdateOrderStatus {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    BitcoinTransactionService bitcoinTransactionService;

    @Autowired
    RestTemplate restTemplate;

    @Scheduled(fixedRate = 10000)
    public void checkOrderStatus() {
        List<Transaction> transactionList = transactionRepository.findByStatusAndPaymentMethod(Status.PENDING, paymentMethodRepository.findByName("Bitcoin"));
        OrderResult orderResult;
        for (Transaction transaction : transactionList){
            orderResult = getOrder(transaction.getAcqOrderId());
            if (orderResult != null){
                bitcoinTransactionService.updateTransaction(orderResult);
            }
        }
    }

    private OrderResult getOrder(Long orderId){
        OrderResult orderResult = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            orderResult = restTemplate.exchange("http://bitcoin/order/" + orderId,
                    HttpMethod.GET, null, new ParameterizedTypeReference<OrderResult>() {}).getBody();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return orderResult;
    }
}
