package com.fastcampus.toyboard.controller;

import com.fastcampus.toyboard.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class AdminController {

    @Autowired
    AdminUserService adminUserService;

    //회원 role 변경
    @PutMapping("/admin/users/{id}/{role}")
    public String manageUserRole(@PathVariable Long id, @PathVariable String role){
        adminUserService.updateUserRoleById(id, role);

        return "/admin/users";
    }
}
