package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.business.service.services.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("products", productServiceImpl.getAll());
        return "index";
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable int id){
         return productServiceImpl.getById(id);
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return productServiceImpl.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid ProductDto productDto){
        this.productServiceImpl.add(productDto);
    }

    @PutMapping
    public void update(@RequestBody ProductDto productDto){
        this.productServiceImpl.update(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.productServiceImpl.delete(id);
    }

    @GetMapping("/get-products-by-category/{category}")
    public String findByCategory(@PathVariable String category, Model model){
        List<ProductDto> productDtos = productServiceImpl.findByCategory(category);
        productDtos.forEach(productDto -> productDto.getCategory().getName());
        model.addAttribute("products", productDtos);
        return "index";
    }
}
