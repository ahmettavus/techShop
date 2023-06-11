package com.ecommerce.techShop.dataAccess.repositories;

import com.ecommerce.techShop.common.repository.BaseRepository;
import com.ecommerce.techShop.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends BaseRepository <Customer, Integer>{
    public Optional<Customer> findCustomerByUsername(String username);
}
