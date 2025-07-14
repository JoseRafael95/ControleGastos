package com.jRafael.ControleGastos.Dto;

import com.jRafael.ControleGastos.Entity.Transaction;
import com.jRafael.ControleGastos.Entity.TransactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {

    private Long id;
    private String description;
    private BigDecimal price;
    private LocalDate date;
    private TransactionType type;

    private UserDto userDto;
    private CategoryDto categoryDto;

    public TransactionDto() {
    }

    public TransactionDto(Long id, String description, BigDecimal price, LocalDate date, TransactionType type, UserDto userDto, CategoryDto categoryDto) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.date = date;
        this.type = type;
        this.userDto = userDto;
        this.categoryDto = categoryDto;
    }

    public TransactionDto(Transaction transaction) {
        id = transaction.getId();
        description = transaction.getDescription();
        price = transaction.getPrice();
        date = transaction.getDate();
        type = transaction.getType();
        categoryDto = new CategoryDto(transaction.getCategory());
        userDto = new UserDto(transaction.getUser());
    }


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }
}
