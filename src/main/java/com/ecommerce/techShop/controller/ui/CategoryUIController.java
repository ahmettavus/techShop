package com.ecommerce.techShop.controller.ui;

import com.ecommerce.techShop.business.dtos.CategoryDto;
import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.business.service.services.ProductServiceImpl;
import com.ecommerce.techShop.controller.CategoryController;
import com.ecommerce.techShop.dataAccess.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("ui/category")
public class CategoryUIController {
    private final CategoryController categoryController;
    private final ProductServiceImpl productService;

    @GetMapping()
    public String getcategories(Model model) {
        List<CategoryDto> categoryDtos = categoryController.getAll();
        List<ProductDto> productDtos = productService.getAll();
        model.addAttribute("products", productDtos);
        model.addAttribute("categories", categoryDtos);
        return "categories";
    }


}
