package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.entity.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    private JavaMailSender javaMailSender;

    @Test
    public void sendMailTest(){

        //given
        Email email = new Email();
        email.setTo("aklmo3778@naver.com");
        email.setSubject("sendMailTest용 메일");
        email.setMessage("sendMailTest용 메일입니다.");

        emailService.sendMail(email);
    }
}
