package com.ecommerce.techShop.business.dtos;

import com.ecommerce.techShop.common.dtos.BaseDtos;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto extends BaseDtos {
//    @NotBlank
//    @NotNull
//    @Size(min = 3, max = 15)
    private String name;

//    @NotBlank
//    @NotNull
//    @Size(min = 10, max = 500)
    private String description;

    private int price;
    private String image;

//    MTO
    private CategoryDto category;

    //OTO
    private int cartId;

    //MTO
//    private int customerId;

    //OTM
    private List<ReviewDto> reviews;
}
