package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Seller {
    @Id
    private int id;

    @Column
    private String name;

    @Column(nullable = false,unique = true)
    private int aadharcard;

    @Column(length = 10)
    private int phonenumber;

    @Column(nullable = false)
    @UniqueElements
    @Email
    private String email;

    @OneToMany(mappedBy = "seller")
    List<Product> productList = new ArrayList<>();
}
