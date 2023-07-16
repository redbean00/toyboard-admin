package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.AdminUserDto;
import com.fastcampus.toyboard.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminUserService {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Transactional
    public void updateUserRoleById(Long userId, String role) {
        AdminUserDto adminUserDto = adminUserRepository.findById(userId);
        adminUserDto.setRole(role);
    }
}
