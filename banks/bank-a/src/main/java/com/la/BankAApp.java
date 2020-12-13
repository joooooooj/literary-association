package com.la;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankAApp {
    public static void main(String[] args) {
        SpringApplication.run(BankAApp.class, args);
    }
}
