package com.jRafael.ControleGastos.Dto;

import com.jRafael.ControleGastos.Entity.User;
import jakarta.persistence.Column;

public class UserDto {

    private long id;
    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
