package com.ecommerce.techShop.business.dtos;

import com.ecommerce.techShop.common.dtos.BaseDtos;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto extends BaseDtos {
//    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
//    @Size(min = 4, max = 15)
    private String name;

//    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
//    @Size(min = 4, max = 500)
    private String description;
    private String image;
    private List<ProductDto> products;



}
