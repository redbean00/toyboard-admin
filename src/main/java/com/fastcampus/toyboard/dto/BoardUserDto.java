package com.fastcampus.toyboard.dto;

import lombok.Setter;

@Setter
public class BoardUserDto {
    private Long boardId;
    private String username;
    private String title;
    private boolean hide;

    public Long getBoardId() {
        return this.boardId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getHide() {
        return this.hide;
    }
}
