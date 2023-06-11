package com.ecommerce.techShop.business.service.serviceInterface;

import com.ecommerce.techShop.business.dtos.ProductDto;

import java.util.List;

public interface ProductService {
//     void add(ProductDto productDto);
//     void update(UpdateProductRequest updateProductRequest);
//     void delete(int id);

//     List<ProductDto> getAll();
//     ProductDto getById(int id);
    List<ProductDto> findByCategory(String categoryName);


}
