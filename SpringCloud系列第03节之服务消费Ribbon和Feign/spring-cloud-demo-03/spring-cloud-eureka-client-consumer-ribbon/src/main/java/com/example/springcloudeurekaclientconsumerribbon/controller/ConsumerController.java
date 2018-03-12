package com.example.springcloudeurekaclientconsumerribbon.controller;

import com.example.springcloudeurekaclientconsumerribbon.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务调用方
 */
@RestController
@RequestMapping("/demo/ribbon")
public class ConsumerController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/toadd")
    public int toadd(int a, int b) {
        return calculatorService.addService(a, b);
    }
}