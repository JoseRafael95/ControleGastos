package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Entity.Category;
import com.jRafael.ControleGastos.Repository.CategoryRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategotyService {

    CategoryRepositry categoryRepositry;

    public Category save(Category category){
        return categoryRepositry.save(category);
    }

    public List<Category> findAll(){
        return categoryRepositry.findAll();
    }

    public Category findByEmail(String email){
        return categoryRepositry.findByEmail(email);
    }

    public void deleteByEmail(String email){
        categoryRepositry.deleteByEmail(email);
    }

}
