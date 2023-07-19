package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.entity.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(Email email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getMessage());

        javaMailSender.send(simpleMailMessage);

    }
}
