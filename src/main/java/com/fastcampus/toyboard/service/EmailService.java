package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.entity.Email;
import com.fastcampus.toyboard.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    private final UserRoleRepository userRoleRepository;

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    public void sendMailAll(Email email){
        List<UserRoleDto> userList = userRoleRepository.findAllWithAuthority();

        for(UserRoleDto user : userList){
            email.setTo(user.getEmail());
            sendMail(email);
        }
    }
    public void sendMail(Email email) {

        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getMessage());

        javaMailSender.send(simpleMailMessage);

    }
}
