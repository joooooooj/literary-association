package com.pcc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/{message}")
    public void testMethod(@PathVariable("message") String message) {
        System.out.println("e usao sam u pcc, radim, bleya i kazem : " + message);
    }
}
