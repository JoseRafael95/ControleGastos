package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Entity.Category;
import com.jRafael.ControleGastos.Entity.DTO.CategoryDto;
import com.jRafael.ControleGastos.Repository.CategoryRepositry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepositry categoryRepositry;

    public CategoryService(CategoryRepositry categoryRepositry) {
        this.categoryRepositry = categoryRepositry;
    }

    public Category save(Category category){
        return categoryRepositry.save(category);
    }

    public List<Category> findAll(){
        return categoryRepositry.findAll();
    }

    public  Category findByName(String name){
        return categoryRepositry.findByName(name);
    }
    @Transactional
    public void deleteByName(String name){
        categoryRepositry.deleteByName(name);
    }

    public Category update(String name, CategoryDto newName){
        Category categoryUpdate = categoryRepositry.findByName(name);
        if(categoryUpdate == null){
            throw new RuntimeException("Categoria não encotrada");
        }
        categoryUpdate.setName(newName.getName());
        return categoryRepositry.save(categoryUpdate);

    }

}
