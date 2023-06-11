package com.ecommerce.techShop.common.service;

import com.ecommerce.techShop.common.dtos.BaseDtos;
import com.ecommerce.techShop.common.entity.BaseEntity;
import com.ecommerce.techShop.common.repository.BaseRepository;
import com.ecommerce.techShop.core.utilities.modelmappers.ModelMapperService;
import com.ecommerce.techShop.model.Cart;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor

public abstract class BaseService
        <RepositoryType extends BaseRepository<EntityType, Integer>,
                EntityType extends BaseEntity,
                DtoType extends BaseDtos> implements BaseServiceImpl<DtoType> {
    protected  RepositoryType repository;
    private  ModelMapperService modelMapperService;


}
