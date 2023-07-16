package com.fastcampus.toyboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AdminBoardDto {
    private Long userId;
    private String title;
    private Timestamp createdAt;
    private Integer hide;
}
