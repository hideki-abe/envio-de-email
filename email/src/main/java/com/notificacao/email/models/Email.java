package com.notificacao.email.models;

import com.notificacao.email.enums.StatusEmail;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class Email {

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public Email(){
        this.ownerRef = "Linketinder";
        this.emailFrom = "Linketinder";
        this.subject = "Alerta de vaga nova";
        this.text = "Uma nova vaga foi cadastrada! Acesse a sua conta para visualizar!";
        this.sendDateEmail = LocalDateTime.now();
    }

}
