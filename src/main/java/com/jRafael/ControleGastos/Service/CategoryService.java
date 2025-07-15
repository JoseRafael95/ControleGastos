package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Dto.CategoryDto;
import com.jRafael.ControleGastos.Entity.Category;
import com.jRafael.ControleGastos.Repository.CategoryRepositry;
import com.jRafael.ControleGastos.Service.exceptions.CategoryNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepositry categoryRepositry;

    public CategoryService(CategoryRepositry categoryRepositry) {
        this.categoryRepositry = categoryRepositry;
    }

    public Page<CategoryDto> findAll(Pageable pageable){
        Page<Category> listCategory = categoryRepositry.findAll(pageable);

        return listCategory.map(x-> new CategoryDto(x));
    }

    public  CategoryDto findByName(String name){
        Category category = new Category();
        category = categoryRepositry.findByName(name);
        if(category == null){
            throw new CategoryNotFoundException("Categoria não encotrada");
        }
        return new CategoryDto(category);
    }

    public CategoryDto save(Category category){
        Category saveCategory = categoryRepositry.save(category);
        return new CategoryDto(category);
    }

    @Transactional
    public void deleteByName(String name){
        categoryRepositry.deleteByName(name);
    }

    public CategoryDto update(String name, Category newName){
        Category categoryUpdate = categoryRepositry.findByName(name);
        if(categoryUpdate == null){
            throw new CategoryNotFoundException("Categoria não encotrada");
        }
        categoryUpdate.setName(newName.getName());
        return new CategoryDto(categoryRepositry.save(categoryUpdate)) ;

    }

}
