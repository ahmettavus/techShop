package com.ecommerce.techShop.business.service.serviceInterface;

import com.ecommerce.techShop.business.dtos.CartDto;

import java.util.List;

public interface CartService  {

    void add(CartDto cartDto);

    void delete(int id);
    void deleteAll(List<CartDto> cartDtos);
    void update(CartDto cartDto);

   List<CartDto> getAll();
   CartDto getById(int id);

//    CartDto findByProductById(Integer productId);

    void addToCart(int productId);


}
