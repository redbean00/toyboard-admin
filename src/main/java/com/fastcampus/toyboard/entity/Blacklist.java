package com.fastcampus.toyboard.entity;

import java.sql.Timestamp;

public class Blacklist {
    private Long id;
    private Long userId;
    private String reason;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer isBlack;
}
