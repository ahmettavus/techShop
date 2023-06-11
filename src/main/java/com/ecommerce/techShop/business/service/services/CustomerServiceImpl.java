package com.ecommerce.techShop.business.service.services;

import com.ecommerce.techShop.business.dtos.CustomerDto;
import com.ecommerce.techShop.business.service.serviceInterface.CustomerService;
import com.ecommerce.techShop.common.service.BaseService;
import com.ecommerce.techShop.core.utilities.modelmappers.ModelMapperService;
import com.ecommerce.techShop.dataAccess.repositories.CartRepository;
import com.ecommerce.techShop.dataAccess.repositories.CustomerRepository;
import com.ecommerce.techShop.model.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl  extends BaseService<CustomerRepository, Customer, CustomerDto>  implements CustomerService{
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ModelMapperService modelMapperService;
    private final CartRepository cartRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void add(CustomerDto customerDto) {
        Customer customer = this.modelMapperService.forRequest().map(customerDto, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void update(CustomerDto customerDto) {

        Customer customer = this.modelMapperService.forRequest().map(customerDto, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);

    }

    @Override
    public void deleteAll(List<CustomerDto> customerDtos) {
        List<Customer> customers = customerDtos.stream()
                .map(cartDto -> this.modelMapperService.forRequest().map(customerDtos, Customer.class))
                .collect(Collectors.toList());
        customerRepository.deleteAll(customers);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerDto> customerDtos = customers.stream()
                .map(customer -> this.modelMapperService.forResponse().map(customer,CustomerDto.class))
                .collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public CustomerDto getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        CustomerDto customerDto = this.modelMapperService.forResponse().map(customer,CustomerDto.class);
        return customerDto;
    }

    @Transactional
    public Optional<Customer> findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    public boolean userExist(String username) {
        return findCustomerByUsername(username).isPresent();
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer register(CustomerDto customerDto) {
        //password encryption
        String password = passwordEncoder.encode(customerDto.getPassword());
        customerDto.setPassword(password);

        Customer customer = new Customer();

        //enable the new user
        customer.setEnabled(true);

        //map userDTO to user
        modelMapper.map(customerDto, customer);
        return save(customer);
    }

}
