package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.CustomerDto;
import com.ecommerce.techShop.business.service.services.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
@Controller
@AllArgsConstructor
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final CustomerServiceImpl customerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String register(@ModelAttribute CustomerDto customerDto, Model model) {
        model.addAttribute("customerDto", customerDto);
        return "register";
    }


    @PostMapping("/register")
    public String save(@Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        //check if the user exist
        if (customerService.userExist(customerDto.getUsername())) {
            bindingResult.addError(new FieldError("customerDto", "username", "username already in use!"));
        }
        //check if the passwords match
        if (customerDto.getPassword() != null && customerDto.getCPassword() != null) {
            if (!customerDto.getPassword().equals(customerDto.getCPassword())) {
                bindingResult.addError(new FieldError("customerDto", "CPassword", "Password must match!"));
            }
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }
        //show success message
        redirectAttributes.addFlashAttribute("message",
                "Success! Your registration is now completed!");

        log.info(">> customerDto : {}", customerDto.toString());
        customerService.register(customerDto);
        return "redirect:/login";
    }

}