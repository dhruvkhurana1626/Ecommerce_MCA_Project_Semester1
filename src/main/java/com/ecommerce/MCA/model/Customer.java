package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    @NotNull
    private int age;

    @Column(nullable = false)
    @Email
    private String email;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(length = 10)
    private int phonenumber;
}
