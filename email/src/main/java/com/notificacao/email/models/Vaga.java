package com.notificacao.email.models;

import lombok.Data;

@Data
public class Vaga {

    private String nome;
    private String descricao;
    private String lugar;

    public Vaga(String nome, String descricao, String lugar) {
        this.nome = nome;
        this.descricao = descricao;
        this.lugar = lugar;
    }


}
