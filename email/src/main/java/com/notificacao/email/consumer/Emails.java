package com.notificacao.email.consumer;

import com.notificacao.email.models.Candidato;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class Emails {

    public ArrayList<String> getEmails(){
        RestTemplate template = new RestTemplate();
        ArrayList<String> emails = new ArrayList<>();
        Candidato[] response = template.getForObject("http://localhost:8082/zghero/candidatos", Candidato[].class);
        assert response != null;
        for (Candidato candidato : response) {
            System.out.println(candidato.getEmail());
            emails.add(candidato.getEmail());
        }
        return emails;
    }


}
