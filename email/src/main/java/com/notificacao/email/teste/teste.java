package com.notificacao.email.teste;

import com.notificacao.email.consumer.Emails;

public class teste {

    public static void main(String[] args) {
        Emails emails = new Emails();
        System.out.println(emails.getEmails().get(0));


    }
}
