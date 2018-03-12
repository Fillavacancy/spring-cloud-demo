package com.example.springcloudeurekaclientconsumerribbon.controller;

import com.example.springcloudeurekaclientconsumerribbon.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ConsumerUploadController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/consumer/uploadPre", method = RequestMethod.GET)
    public String uploadPre() {
        return "upload";
    }

    @ResponseBody
    @RequestMapping(value = "/consumer/upload", method = RequestMethod.POST)
    public String upload(String name, MultipartFile photo) throws Exception {
        if (photo != null) {
            return calculatorService.uploadService(name, photo);
        }
        return "nophoto.jpg";
    }
}