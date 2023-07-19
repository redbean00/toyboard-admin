package com.fastcampus.toyboard.controller;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    @Autowired
    private final UserService userService;

    @GetMapping("/admin")
    public String main(){
        return "/thymeleaf/admin";
    }

    //회원 관리 페이지 - 전체 회원 목록 보여주고 등급을 변경할 수 있음
    @GetMapping("/admin/user")
    public String showUserListWithAuthority(Model model){
        List<UserRoleDto> userList = userService.getUserListWithAuthority();
        model.addAttribute("userList", userList);
        return "/thymeleaf/user";
    }

    //회원 등급 변경
    @PostMapping("/admin/user/{userId}")
    public String manageUserAuthority(@PathVariable Long userId, UserRoleDto userRoleDto){
        userService.updateUserRole(userId, userRoleDto);
        return "redirect:/admin/user";
    }

    //이메일 전송
    @GetMapping("/admin/email")
    public String email(){
        return "/thymeleaf/email";
    }
}
