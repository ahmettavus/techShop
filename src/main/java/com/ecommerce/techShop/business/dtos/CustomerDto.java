package com.ecommerce.techShop.business.dtos;

import com.ecommerce.techShop.common.dtos.BaseDtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto extends BaseDtos {


    private String name;

    private String phoneNumber;

    private String username;


    private String password;

    private String cPassword;

    private String email;

    private String address;

    private int age;

//    private List<ProductDto> productDto;

//    private int cartId;

    private List<ReviewDto> reviews;

    private CartDto cartDto;

}
