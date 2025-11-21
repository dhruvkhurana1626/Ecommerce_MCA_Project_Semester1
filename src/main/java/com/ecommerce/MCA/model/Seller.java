package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Seller {
    @Id
    int id;

    @Column
    String name;

    @Column(nullable = false)
    int aadharcard;

    @Column
    int age;

    @Column
    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @Column(length = 10)
    int phonenumber;

    @Column(nullable = false)
    @UniqueElements
    @Email
    String email;
}
