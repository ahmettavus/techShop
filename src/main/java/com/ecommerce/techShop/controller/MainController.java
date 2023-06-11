package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.business.service.services.CustomerServiceImpl;
import com.ecommerce.techShop.business.service.services.ProductServiceImpl;
import com.ecommerce.techShop.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@Controller
@AllArgsConstructor
public class MainController {
    private ProductServiceImpl productService;

    private CustomerServiceImpl customerService;


    @GetMapping("/")
    public String index(Authentication authentication) {

        return authentication == null ? "index" : "redirect:/authenticated";
    }

    @GetMapping("/authenticated")
    public String authenticated(Model model) {
        List<ProductDto> productDtoList = productService.getAll();
        model.addAttribute("products", productDtoList);
        return "authenticated";
    }



    @GetMapping("/login")
    public String login(Authentication authentication) {
        return authentication == null ? "login" : "redirect:/authenticated";
    }

    @GetMapping("/index")
    public String showHomePage(Model model, Principal principal){
        if (principal != null) {
            String username = principal.getName();
            Optional<Customer> customer = customerService.findCustomerByUsername(username);
            model.addAttribute("customer", customer);
            return "index";
        }

        List<ProductDto> productDtoList = productService.getAll();
        model.addAttribute("products", productDtoList);
        return "login";
    }

//    @GetMapping("/")
//    public ModelAndView showWelcomePage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//
//        List<ProductDto> productDtoList = productService.getAll();
//        modelAndView.addObject("products", productDtoList);
//        return modelAndView;
//    }
}
