package com.ecommerce.techShop.business.dtos;

import com.ecommerce.techShop.business.rules.MessageConstants;
import com.ecommerce.techShop.common.dtos.BaseDtos;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDto extends BaseDtos {


    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    private String name;

//    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
//    @Size(min = 1, max = 99)
    private int quantity;

//    @NotNull(message = MessageConstants.MESSAGE_NOT_BLANK)
//    @Min(50)
//    @Max(1000)
    private int totalPrice;

//    private ProductDto product;

    private  CustomerDto customerDto;

    private ProductDto product;

}
