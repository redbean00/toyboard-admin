package com.fastcampus.toyboard.controller;

import com.fastcampus.toyboard.dto.AdminBoardDto;
import com.fastcampus.toyboard.entity.EmailMessage;
import com.fastcampus.toyboard.service.AdminBoardService;
import com.fastcampus.toyboard.service.AdminUserService;
import com.fastcampus.toyboard.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    EmailService emailService;

    @Autowired
    AdminBoardService adminBoardService;

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

    //게시글 목록보기
    @GetMapping("/admin/boards")
    public String showBoardList(Model model) {
        List<AdminBoardDto> adminBoardDtoList = adminBoardService.findBoardList();
        model.addAttribute("boardList", adminBoardDtoList);
        return "/admin/boards/list";
    }

    //게시글 삭제
    @DeleteMapping("/admin/boards/{id}")
    public String deleteBoard(@PathVariable Long id) {
        adminBoardService.deleteBoardById(id);
        return "/admin/boards";
    }

    //게시글 숨기기, 보이기
    @PutMapping("/admin/boards/{id}")
    public String hideBoard(@PathVariable Long id) {
        adminBoardService.hideBoardById(id);
        return "/admin/boards";
    }
}
