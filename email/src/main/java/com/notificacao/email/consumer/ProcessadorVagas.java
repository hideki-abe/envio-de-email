package com.notificacao.email.consumer;

import com.notificacao.email.controllers.EmailController;
import com.notificacao.email.enums.StatusEmail;
import com.notificacao.email.models.Candidato;
import com.notificacao.email.models.Email;
import com.notificacao.email.models.EmailModel;
import com.notificacao.email.models.Vaga;
import com.notificacao.email.services.EmailService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ProcessadorVagas {

    public void consumer(EmailService emailService) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "email");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try (KafkaConsumer<String, Vaga> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Arrays.asList("email"));
            Emails emails = new Emails();
            Email emailModel = new Email();
            while (true) {
                ConsumerRecords<String, Vaga> vagas = consumer.poll(Duration.ofMillis(200));
                for (ConsumerRecord<String, Vaga> record : vagas) {
                    for(String email: emails.getEmails()){
                        emailModel.setEmailTo(email);
                        System.out.println("Enviando email" + emailModel);
                        emailService.sendMessage(emailModel);
                    }

                }
            }
        }
    }

}
