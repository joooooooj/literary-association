package com.la.feignClients;

import com.la.security.UserTokenState;
import com.la.security.auth.JwtAuthenticationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-api-gateway")
public interface PaymentConcentratorFeignClient {

    @PostMapping(value = "/api/auth/login")
    UserTokenState login(@RequestBody JwtAuthenticationRequest authenticationRequest);

}
