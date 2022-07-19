package com.notificacao.email.controllers;


import com.notificacao.email.consumer.Emails;
import com.notificacao.email.dtos.EmailDto;
import com.notificacao.email.models.EmailModel;
import com.notificacao.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail() {
        EmailModel emailModel = new EmailModel();
        Emails emails = new Emails();
        //System.out.println(emails.getEmails().get(0));
        for(String email: emails.getEmails()){
            emailModel.setEmailTo(email);
            emailService.sendEmail(emailModel);
        }
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}
