package com.jRafael.ControleGastos.Dto;

import com.jRafael.ControleGastos.Entity.Category;

public class CategoryDto {

    private long id;
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
