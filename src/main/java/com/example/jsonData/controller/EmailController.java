package com.example.jsonData.controller;

import com.example.jsonData.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")

public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("sendEmail")
    public String sendEmail() {
        emailService.sendMail("soham.shiraskar@ofbusiness.in", "Hello Soham", "Test Subject");
        return "Sent Successfully";
    }
}
