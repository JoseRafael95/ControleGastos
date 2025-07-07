package com.jRafael.ControleGastos.Repository;

import com.jRafael.ControleGastos.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositry extends JpaRepository<Category, Long> {

    Category findByEmail(String email);

    void deleteByEmail(String email);
}
