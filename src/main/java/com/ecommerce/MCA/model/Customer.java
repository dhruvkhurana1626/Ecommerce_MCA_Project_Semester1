package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Customer {
    @Id
    int id;

    @Column
    String name;

    @Column
    @NotNull
    int age;

    @Column(nullable = false)
    @Email
    String email;

    @Column
    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @Column(length = 10)
    int phonenumber;
}
