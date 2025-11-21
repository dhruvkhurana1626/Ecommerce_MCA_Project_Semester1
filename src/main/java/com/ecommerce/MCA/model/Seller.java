package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(nullable = false)
    private int aadharcard;

    @Column
    private int age;

    @Column(length = 10)
    private int phonenumber;

    @Column(nullable = false)
    @UniqueElements
    @Email
    private String email;
}
