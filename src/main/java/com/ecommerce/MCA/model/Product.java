package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Enumerated(value = EnumType.STRING)
    Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    Seller seller;

    @OneToMany(mappedBy = "product")
    List<Review> review = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<Orderentity> orders = new ArrayList<>();

}
