package com.coopera_rs.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public void confirmaEmail(String destinatario,String link){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(remetente);
            message.setTo(destinatario);
            message.setSubject("Confirmação de email");
            message.setText("Clique no link para confirmar seu email: " + link);
            mailSender.send(message);
        }catch (Exception e){
            System.out.println("Erro ao enviar e-mail");
        }
    }
}
