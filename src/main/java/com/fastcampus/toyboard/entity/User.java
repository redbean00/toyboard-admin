package com.fastcampus.toyboard.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
