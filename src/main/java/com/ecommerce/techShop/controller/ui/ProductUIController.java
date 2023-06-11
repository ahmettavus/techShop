package com.ecommerce.techShop.controller.ui;

import com.ecommerce.techShop.business.dtos.CartDto;
import com.ecommerce.techShop.business.dtos.CategoryDto;
import com.ecommerce.techShop.business.dtos.CustomerDto;
import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.business.service.services.CartServiceImpl;
import com.ecommerce.techShop.business.service.services.CustomerServiceImpl;
import com.ecommerce.techShop.business.service.services.ProductServiceImpl;
import com.ecommerce.techShop.controller.CartController;
import com.ecommerce.techShop.controller.CategoryController;
import com.ecommerce.techShop.controller.CustomerController;
import com.ecommerce.techShop.controller.ProductController;
import com.ecommerce.techShop.model.Customer;
import com.ecommerce.techShop.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("ui/product")
public class ProductUIController {
    private final CategoryController categoryController;
    private final ProductController productController;
    private final CartController cartController;

    private final CustomerServiceImpl customerService;
    private final CartServiceImpl cartServiceImpl;

    private final CustomerController customerController;
    private final ProductServiceImpl productService;

    @GetMapping("by-category/{categoryId}")
    public String getProductsByCategory(Model model, @PathVariable Integer categoryId) {
        CategoryDto categoryDto = categoryController.getById(categoryId);
        model.addAttribute("products", categoryDto.getProducts());
        return "products";
    }

    @GetMapping("{productId}")
    public String getProductById(Model model, @PathVariable Integer productId) {
        ProductDto productDto = productController.getById(productId);
        model.addAttribute("products", productDto);
        return "productdetails";

    }

    @PostMapping("/save/{productId}")
    public String addToCart(Model model, @PathVariable Integer productId) {
        CartDto cartDto = new CartDto();

        ProductDto productDto = productService.getById(productId);

        cartDto.setProduct(productDto);

        CustomerDto customerDto = new CustomerDto();
        int customerId = 1;
        customerDto.setId(customerId);

        cartDto.setCustomerDto(customerDto);

        cartDto.setQuantity(1);

        cartServiceImpl.add(cartDto);

        model.addAttribute("carts", cartDto);

        return "redirect:/api/carts";
    }

}



