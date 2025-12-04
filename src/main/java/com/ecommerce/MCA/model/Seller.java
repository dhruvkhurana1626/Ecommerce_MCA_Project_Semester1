package com.ecommerce.MCA.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(nullable = false,unique = true)
    private String aadharcard;

    @Column(length = 10)
    private String phonenumber;

    @Column(nullable = false)
    @Email
    private String email;

    @CreationTimestamp
    Date createdAt;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> products = new ArrayList<>();

}
