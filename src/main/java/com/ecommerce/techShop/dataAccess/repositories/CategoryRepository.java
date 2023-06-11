package com.ecommerce.techShop.dataAccess.repositories;

import com.ecommerce.techShop.common.repository.BaseRepository;
import com.ecommerce.techShop.model.Category;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends BaseRepository <Category, Integer>{
}
