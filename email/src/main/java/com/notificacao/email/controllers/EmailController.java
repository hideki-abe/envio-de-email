package com.notificacao.email.controllers;


import com.notificacao.email.consumer.Emails;
import com.notificacao.email.consumer.ProcessadorVagas;
import com.notificacao.email.models.Email;
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

    EmailService emailService = new EmailService();

    public EmailController(){
        ProcessadorVagas processador = new ProcessadorVagas();
        processador.consumer(emailService);
    }

    @GetMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail() {
        EmailModel emailModel = new EmailModel();
        Emails emails = new Emails();
        for(String email: emails.getEmails()){
            emailModel.setEmailTo(email);
            emailService.sendEmail(emailModel);
            System.out.println("Enviando um email");
        }
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
