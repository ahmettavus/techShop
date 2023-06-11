package com.ecommerce.techShop.business.service.serviceInterface;

import com.ecommerce.techShop.business.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    void add(CustomerDto customerDto);

    void delete(int id);
    void deleteAll(List<CustomerDto> customerDtos);
    void update(CustomerDto customerDto);

    List<CustomerDto> getAll();
    CustomerDto getById(int id);
}
