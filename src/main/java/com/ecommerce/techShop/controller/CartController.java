package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.CartDto;
import com.ecommerce.techShop.business.service.services.CartServiceImpl;
import com.ecommerce.techShop.business.service.services.CustomerServiceImpl;
import com.ecommerce.techShop.business.service.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/carts")
public class CartController {
    private final CartServiceImpl cartService;
    private final ProductServiceImpl productServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;


    public CartController(CartServiceImpl cartService, ProductServiceImpl productServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.cartService = cartService;
        this.productServiceImpl = productServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
    }


    @GetMapping
    public String getCart(Model model) {
        List<CartDto> cartDtos = cartService.getAll();
        int totalCartPrice = 0;

        for (CartDto cart : cartDtos) {
            int productTotalPrice = cart.getQuantity() * cart.getProduct().getPrice();
            cart.setTotalPrice(productTotalPrice);
            totalCartPrice += productTotalPrice;
        }

        model.addAttribute("carts", cartDtos);
        model.addAttribute("totalCartPrice", totalCartPrice); // Toplam sepet fiyatını modele ekle

        return "cart";
    }


    @GetMapping("/{id}")
    public List<CartDto> getById(@PathVariable int id) {
        return getById(id);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CartDto cartDto) {
        this.cartService.add(cartDto);
    }

    @PostMapping(value = "/update-cart", params = "action=update")
    public String updateCart(@RequestParam("quantity") int quantity,
                             @RequestParam("id") Integer cartId, Model model) {

        CartDto cartDto = cartService.getById(cartId);
        cartDto.setQuantity(quantity);
        cartService.update(cartDto);

        return "redirect:/api/carts";

    }
    @PostMapping(value = "/delete-cart", params = "action=delete")
    public String deleteCartItem(@RequestParam("id") Integer cartId, Model model) {
        CartDto cartDto = cartService.getById(cartId);
//        cartDto.setQuantity(0);
        cartService.update(cartDto);
        cartService.delete(cartDto.getId());
        return "redirect:/api/carts";
    }

    @GetMapping("/checkout")
    public String checkoutpage(){
        return "checkout";
    }

    @PostMapping(value = "/delete-cart-all", params = "action=delete")
    public String deleteCart() {
        List<CartDto> cartDtos = this.cartService.getAll();
        this.cartService.deleteAll(cartDtos);
        return "redirect:/api/carts/checkout";
    }



    @PutMapping
    public void update(@RequestBody CartDto cartDto) {
        this.cartService.update(cartDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.cartService.delete(id);
    }

}
