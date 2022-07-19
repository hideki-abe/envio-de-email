package com.notificacao.email.teste;

import com.notificacao.email.models.Candidato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class testeApi {

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:8083")
                .path("zghero/candidatos")
                .build();


        Candidato[] response = template.getForObject("http://localhost:8083/zghero/candidatos", Candidato[].class);

        System.out.println(Arrays.toString(response));
        assert response != null;

        for(int i=0; i<response.length;i++){
            System.out.println(response[i].getEmail());
        }

    }

}
