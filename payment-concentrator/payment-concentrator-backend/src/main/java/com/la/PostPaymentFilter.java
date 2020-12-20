package com.la;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.la.dto.PaypalCreateOrderDTO;
import com.la.model.Status;
import com.la.model.Transaction;
import com.la.repository.TransactionRepository;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@CrossOrigin(value = "http://localhost:3000")
public class PostPaymentFilter extends ZuulFilter {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("usao je u post filter, valjda posle pazpala");

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("merchantOrderId" + context.get("merchantOrderId"));
        System.out.println("merchantTimestamp" + context.get("merchantTimestamp"));
        try (final InputStream responseDataStream = context.getResponseDataStream()) {

            if (responseDataStream == null) {
                return null;
            }

            String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));

            context.setResponseBody(responseData);
            System.out.println(responseData);
            PaypalCreateOrderDTO orderDTO = new ObjectMapper().readValue(responseData, PaypalCreateOrderDTO.class);

            Transaction transaction = new Transaction();
            transaction.setAcqOrderId(orderDTO.getOrderId());
            transaction.setAcqTimestamp(LocalDateTime.now());
            transaction.setMerchantOrderId(Long.parseLong(context.get("merchantOrderId").toString()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            transaction.setMerchantTimestamp(LocalDateTime.parse(context.get("merchantTimestamp").toString(), formatter));
            transaction.setStatus(Status.PENDING);
            transactionRepository.save(transaction);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        return null;
    }
}
