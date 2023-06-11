package com.ecommerce.techShop.model;

import com.ecommerce.techShop.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends BaseEntity {

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private int price;

        @Column(name = "image")
        private String image;

        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

        @OneToOne(cascade = CascadeType.ALL)
//        @JoinColumn(name = "cart_id", referencedColumnName = "id")
        private Cart cart;

//        @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
//        private Cart cart;
//        @ManyToOne
//        @JoinColumn(name = "customer_id")
//        private Customer customer;

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
        private List<Review> reviews;


    }
