package com.fastcampus.toyboard.controller;

import com.fastcampus.toyboard.entity.EmailMessage;
import com.fastcampus.toyboard.service.AdminUserService;
import com.fastcampus.toyboard.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminController {

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    EmailService emailService;

    //회원 role 변경
    @PutMapping("/admin/users/{id}/{role}")
    public String manageUserRole(@PathVariable Long id, @PathVariable String role) {
        adminUserService.updateUserRoleById(id, role);

        return "/admin/users";
    }

    //email 전송
    @PostMapping("/admin/users/id}")
    public ResponseEntity sendMail(@RequestBody EmailMessage emailMessage) {
        EmailMessage message = EmailMessage.builder()
                .to(emailMessage.getTo())
                .subject(emailMessage.getSubject())
                .message(emailMessage.getMessage())
                .build();

        emailService.sendMail(message);

        return ResponseEntity.ok().build();
    }
}
