package com.ecommerce.techShop.business.service.services;

import com.ecommerce.techShop.business.dtos.CategoryDto;
import com.ecommerce.techShop.business.service.serviceInterface.CategoryService;
import com.ecommerce.techShop.common.service.BaseService;
import com.ecommerce.techShop.core.utilities.modelmappers.ModelMapperService;
import com.ecommerce.techShop.dataAccess.repositories.CategoryRepository;
import com.ecommerce.techShop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CategoryServiceImpl  extends BaseService<CategoryRepository, Category, CategoryDto> implements CategoryService{

    private  CategoryRepository categoryRepository;
    private  ModelMapperService modelMapperService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
        super(categoryRepository,modelMapperService);
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public void add(CategoryDto categoryDtos) {
        Category category = this.modelMapperService.forRequest().map(categoryDtos,Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void update(CategoryDto categoryDtos) {
        Category category = this.modelMapperService.forRequest().map(categoryDtos, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
    this.categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<CategoryDto> categoryDtos) {
        List<Category> categories = categoryDtos.stream()
                .map(cartDto -> this.modelMapperService.forRequest().map(categoryDtos, Category.class))
                .collect(Collectors.toList());
        categoryRepository.deleteAll(categories);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories= categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(category -> this.modelMapperService.forResponse().map(category, CategoryDto.class))
                .collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public CategoryDto getById(int id) {
        Category category = this.categoryRepository.findById(id).orElseThrow();
        CategoryDto categoryDto = this.modelMapperService
                .forResponse().map(category,CategoryDto.class);
        return categoryDto;
    }
}
