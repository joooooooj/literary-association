package com.pcc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PCCApp {
    public static void main(String[] args) {
        SpringApplication.run(PCCApp.class, args);
    }
}
