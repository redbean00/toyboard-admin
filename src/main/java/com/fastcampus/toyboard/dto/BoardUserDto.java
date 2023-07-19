package com.fastcampus.toyboard.dto;

import lombok.Getter;

@Getter
public class BoardUserDto {
    private String id;
    private String username;
    private String title;
    private Boolean hide;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }
}
