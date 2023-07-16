package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.entity.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender javaMailSender;


    @Async
    public boolean sendMail(EmailMessage emailMessage){
        boolean msg = false;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(emailMessage.getTo());
        simpleMailMessage.setSubject(emailMessage.getSubject());
        simpleMailMessage.setFrom("admin");
        simpleMailMessage.setText(emailMessage.getMessage());

        try{
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            e.printStackTrace();
            return msg;
        }

        return msg = true;
    }
}
