package com.ecommerce.techShop.business.service.services;

import com.ecommerce.techShop.business.dtos.CartDto;
import com.ecommerce.techShop.business.dtos.CustomerDto;
import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.business.service.serviceInterface.CartService;
import com.ecommerce.techShop.common.service.BaseService;
import com.ecommerce.techShop.core.utilities.modelmappers.ModelMapperService;
import com.ecommerce.techShop.dataAccess.repositories.CartRepository;
import com.ecommerce.techShop.model.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CartServiceImpl extends BaseService<CartRepository, Cart, CartDto> implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapperService modelMapperService;

    private final  ProductServiceImpl productService;

    private final CustomerServiceImpl customerService;

    @Override
    public void add(CartDto cartDto) {
        Cart cart = this.modelMapperService.forRequest().map(cartDto,Cart.class);
        this.cartRepository.save(cart);
    }

    @Override
    public void delete(int id) {
        this.cartRepository.deleteById(id);

    }

    @Override
    public void deleteAll(List<CartDto> cartDtos) {
        List<Cart> carts = cartDtos.stream()
                .map(cartDto -> this.modelMapperService.forRequest().map(cartDto, Cart.class))
                .collect(Collectors.toList());
        cartRepository.deleteAll(carts);
    }

    @Override
    public void update(CartDto cartDto) {
        Cart cart = this.modelMapperService.forRequest().map(cartDto,Cart.class);
       cart.setId(cart.getId());
        this.cartRepository.save(cart);
    }


    @Override
    public List<CartDto> getAll() {
        List<Cart> carts = this.cartRepository.findAll();
        List<CartDto> cartDtos = carts.stream()
                .map(cart -> this.modelMapperService.forResponse().map(cart,CartDto.class))
                .collect(Collectors.toList());
        return cartDtos;
    }

    @Override
    public CartDto getById(int id) {
        Cart cart = this.cartRepository.findById(id).orElseThrow();
        CartDto cartDto = this.modelMapperService
                .forResponse().map(cart,CartDto.class);
        cartDto.setId(cart.getId());
        return cartDto;
    }



    @Override
    public void addToCart(int productId) {
        ProductDto productDto = productService.getById(productId);
       // CustomerDto customerDto = customerService.getById(productDto.getCustomerDto().getId());

        Cart cart = new Cart();
        cart.setName(productDto.getName());
//        cart.setQuantity(quantity);
//        cart.setTotalPrice(productDto.getPrice() * quantity);

        CartDto cartDto = this.modelMapperService
                .forResponse().map(cart,CartDto.class);
        this.cartRepository.save(cart);

    }



//    @Override
//    public CartDto findByProductById(Integer productId) {
//        Cart carts = this.cartRepository.findByProductById(productId);
//
//      CartDto cartDto = this.modelMapperService.forResponse().map(carts, CartDto.class);
//        return cartDto;
//    }

}
