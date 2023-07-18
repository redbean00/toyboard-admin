package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.entity.User;
import com.fastcampus.toyboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<UserRoleDto> getUserList(){
        return userRepository.findAll();
    }

    public void updateUserRole(UserRoleDto userRoleDto){
        userRepository.updateById(userRoleDto);
    }
}
