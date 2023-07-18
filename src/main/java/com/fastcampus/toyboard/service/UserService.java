package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRoleRepository userRepository;

    public List<UserRoleDto> getUserListWithAuthority(){
        return userRepository.findAllWithAuthority();
    }

    public void updateUserRole(Long userId, String authority){
        UserRoleDto user = new UserRoleDto();
        user.setUserId(userId);
        user.setAuthority(authority);
        userRepository.updateById(user);
    }
}
