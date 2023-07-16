package com.fastcampus.toyboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AdminUserDto {
    private Timestamp createdAt;
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String role;

}
