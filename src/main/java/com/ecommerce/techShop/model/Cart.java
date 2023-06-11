package com.ecommerce.techShop.model;

import com.ecommerce.techShop.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private int totalPrice;

//    @OneToOne(mappedBy = "cart")
//    //  @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;

    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

//    @OneToOne(mappedBy = "cart")
//    // @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
