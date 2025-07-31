package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Dto.CategoryDto;
import com.jRafael.ControleGastos.Entity.Category;
import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Repository.CategoryRepositry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {


    @Mock
    private CategoryRepositry categoryRepositry;

    @InjectMocks
    private CategoryService categoryService;

    private Category category;
    private CategoryDto categoryDto;

    @BeforeEach
    void setUp(){
        category = new Category();
        category.setId(1L);
        category.setName("categoria");

        categoryDto = new CategoryDto(category);

    }

    @Test
    void findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Category> userPage = new PageImpl<>(Collections.singletonList(category), pageable, 1);
        doReturn(userPage).when(categoryRepositry).findAll(pageable);

        Page<CategoryDto> result = categoryService.findAll(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(category.getName(), result.getContent().get(0).getName());
        verify(categoryRepositry, times(1)).findAll(pageable);

    }

    @Test
    void findByName() {
        when(categoryRepositry.findByName(category.getName())).thenReturn(category);

        CategoryDto result = categoryService.findByName(category.getName());

        assertNotNull(result);
        assertEquals(category.getName(), result.getName());

    }

    @Test
    void save() {
        when(categoryRepositry.save(category)).thenReturn(category);

        CategoryDto result = categoryService.save(category);

        assertNotNull(result);
        assertEquals(category.getName(), result.getName());

    }

    @Test
    void deleteByName() {
        doNothing().when(categoryRepositry).deleteByName(category.getName());

        categoryService.deleteByName(category.getName());

        verify(categoryRepositry, times(1)).deleteByName(category.getName());

    }

    @Test
    void update() {
    }
}