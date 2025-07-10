package com.jRafael.ControleGastos.Controller;

import com.jRafael.ControleGastos.Entity.Category;
import com.jRafael.ControleGastos.Entity.DTO.CategoryDto;
import com.jRafael.ControleGastos.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name){
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        return  ResponseEntity.ok(categoryService.save(category));
    }

    @PutMapping("/{name}")
    public ResponseEntity<Category> update(@PathVariable String name, @RequestBody CategoryDto update){
       return ResponseEntity.ok(categoryService.update(name, update));

    }

    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable String name){
        categoryService.deleteByName(name);
    }


}
