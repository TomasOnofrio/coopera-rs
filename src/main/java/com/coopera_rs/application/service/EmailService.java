package com.coopera_rs.application.service;
import com.coopera_rs.core.User;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public boolean sendPasswordLink(User user, String url) {
        String token = UUID.randomUUID().toString();
        url += token;
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(remetente);
            message.setTo(user.getEmail());
            message.setSubject("Link para troca de senha");
            message.setText("Clique no link para trocar sua senha: " + url);
            mailSender.send(message);
            return true;
        }catch (Exception e){
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
        return false;
    }
}
