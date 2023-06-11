package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.model.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AddCustomerToView {

    @ModelAttribute("customer")
    public Customer addCustomerToView(Authentication authentication) {
        return authentication != null ? (Customer) authentication.getPrincipal() : null;
    }

}
