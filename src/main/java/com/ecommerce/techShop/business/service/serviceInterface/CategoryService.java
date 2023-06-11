package com.ecommerce.techShop.business.service.serviceInterface;

import com.ecommerce.techShop.business.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    void add(CategoryDto categoryDtos);

    void delete(int id);
    void deleteAll(List<CategoryDto> categoryDtos);
    void update(CategoryDto categoryDtos);

    List<CategoryDto> getAll();
    CategoryDto getById(int id);
}
