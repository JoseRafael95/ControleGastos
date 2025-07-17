package com.jRafael.ControleGastos.Controller;

import com.jRafael.ControleGastos.Dto.CategoryDto;
import com.jRafael.ControleGastos.Entity.Category;

import com.jRafael.ControleGastos.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<Page<CategoryDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(categoryService.findAll(pageable));
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDto> findByName(@PathVariable String name){
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody Category category){
        return  ResponseEntity.ok(categoryService.save(category));
    }

    @PutMapping("/{name}")
    public ResponseEntity<CategoryDto> update(@PathVariable String name, @Valid @RequestBody Category update){
       return ResponseEntity.ok(categoryService.update(name, update));

    }

    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable String name){
        categoryService.deleteByName(name);
    }


}
