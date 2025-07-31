package com.jRafael.ControleGastos.Dto;

import com.jRafael.ControleGastos.Entity.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class UserDto {

    private long id;
    @NotBlank(message = "O nome do usuário não pode ser nulo.")
    private String name;
    @NotBlank(message = "O nome do usuário não pode ser nulo.")
    private String email;
    @NotBlank(message = "O nome do usuário não pode ser nulo.")
    private String senha;

    public UserDto() {
    }

    public UserDto(long id, String name, String email, String senha) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    }

    public long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
