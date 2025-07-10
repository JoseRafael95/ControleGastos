package com.jRafael.ControleGastos.Repository;

import com.jRafael.ControleGastos.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositry extends JpaRepository<Category, Long> {

    Category findByName(String name);

    void deleteByName(String name);

}
