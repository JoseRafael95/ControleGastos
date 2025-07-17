package com.jRafael.ControleGastos.Dto;

import com.jRafael.ControleGastos.Entity.Category;
import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

    private long id;
    @NotBlank(message = "O nome do usuário não pode ser nulo.")
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
