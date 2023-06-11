package com.ecommerce.techShop.common.service;

import com.ecommerce.techShop.business.dtos.CartDto;
import com.ecommerce.techShop.common.dtos.BaseDtos;

import java.util.List;
import java.util.UUID;

public interface BaseServiceImpl <DtoType extends BaseDtos> {


//    void add(CartDto cartDto);
//
//    void delete(UUID id);
//    void deleteAll(List<CartDto> cartDtos);
//    void update(CartDto cartDto);
//
//    List<CartDto> getAll();
//    CartDto getById(UUID id);
    void add(DtoType dtoType);
    void delete(int uuid);
    void deleteAll(List<DtoType> dtoTypes);

    void update(DtoType dtoType);

    List<DtoType> getAll();

    DtoType getById(int uuid);

}
