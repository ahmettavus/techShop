package com.ecommerce.techShop.dataAccess.repositories;

import com.ecommerce.techShop.common.repository.BaseRepository;
import com.ecommerce.techShop.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends BaseRepository <Cart, Integer>{
//    Cart findByProductById(Integer productId);

}
