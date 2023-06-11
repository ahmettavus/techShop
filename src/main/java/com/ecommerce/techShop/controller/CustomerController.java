package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.CustomerDto;
import com.ecommerce.techShop.business.service.services.CustomerServiceImpl;
import com.ecommerce.techShop.dataAccess.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerServiceImpl customerServiceImpl;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl,
                              CustomerRepository customerRepository) {
        this.customerServiceImpl = customerServiceImpl;
        this.customerRepository = customerRepository;
    }


//    @GetMapping("/{id}")
//    public List<CustomerDto> getById(@PathVariable int id){
//        return getById(id);
//    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable int id){
        return customerServiceImpl.getById(id);
    }

    @GetMapping
    public List<CustomerDto> getAll(){
        return customerServiceImpl.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CustomerDto customerDto){
        this.customerServiceImpl.add(customerDto);
    }

    @PutMapping
    public void update(@RequestBody CustomerDto customerDto){
        this.customerServiceImpl.update(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.customerServiceImpl.delete(id);
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute("customerDto") @Valid CustomerDto customerDto, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        customerServiceImpl.add(customerDto);
        SecurityContextHolder.clearContext();

        return "redirect:/login";
    }

}
