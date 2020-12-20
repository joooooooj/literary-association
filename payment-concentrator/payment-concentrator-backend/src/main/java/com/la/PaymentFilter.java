package com.la;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.la.dto.PaypalCreateOrderDTO;
import com.la.dto.PaypalOrderDTO;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
@CrossOrigin(value = "http://localhost:3000")
public class PaymentFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Usao je u zuul");

        // rbac

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        if (request.getRequestURI().contains("pay-pal/create")) {
            try {
                PaypalOrderDTO paypalOrderDTO = extractBody(context);
                if (paypalOrderDTO == null) {
                    setFailedRequest("Request does not contain all data.", 400);
                }
                context.set("merchantOrderId", paypalOrderDTO.getMerchantOrderId());
                context.set("merchantTimestamp", paypalOrderDTO.getMerchantTimestamp());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    private PaypalOrderDTO extractBody(RequestContext context) throws JsonProcessingException {
        InputStream in = (InputStream) context.get("requestEntity");
        if (in == null) {
            try {
                in = context.getRequest().getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        String body = null;
        try {
            body = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("telo je " + body);
        PaypalOrderDTO paypalOrderDTO = null;
        try {
            paypalOrderDTO = new ObjectMapper().readValue(body, PaypalOrderDTO.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        }
        return paypalOrderDTO;
    }
}
