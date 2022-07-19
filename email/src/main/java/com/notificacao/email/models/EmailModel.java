package com.notificacao.email.models;

import com.notificacao.email.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public EmailModel(){
        this.ownerRef = "Linketinder";
        this.emailFrom = "Linketinder";
        this.subject = "Alerta de vaga nova";
        this.text = "Uma nova vaga foi cadastrada! Acesse a sua conta para visualizar!";
        this.sendDateEmail = LocalDateTime.now();
    }

}
