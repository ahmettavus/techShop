package com.ecommerce.techShop.business.dtos;

import com.ecommerce.techShop.common.dtos.BaseDtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReviewDto extends BaseDtos {
//    @NotBlank
//    @NotNull
//    @Size(min = 3, max = 15)
    private String name;

//    @NotBlank
//    @NotNull
//    @Size(min = 3, max = 500)
    private String comment;

//    @NotBlank
//    @NotNull
//    @Size()
    private String date;

    private int customerId;
    private int productId;

}
