package com.ecommerce.techShop.dataAccess.repositories;

import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.common.repository.BaseRepository;
import com.ecommerce.techShop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository <Product, Integer> {
     List<Product> findByCategory(String categoryName);
}
