package com.fastcampus.toyboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserRoleDto {
    private Long id;
    private String username;
    private String email;
    private String nickname;
    private Timestamp createdAt;
    private String role;
}
