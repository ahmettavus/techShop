package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.CategoryDto;
import com.ecommerce.techShop.business.service.services.CategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryServiceImpl.getById(id);
    }

    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryServiceImpl.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CategoryDto categoryDto) {
        this.categoryServiceImpl.add(categoryDto);
    }

    
    @PutMapping
    public void update(@RequestBody CategoryDto categoryDto){
        this.categoryServiceImpl.update(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.categoryServiceImpl.delete(id);
    }


}
