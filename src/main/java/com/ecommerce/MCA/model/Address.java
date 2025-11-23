package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="address_details")
public class Address {
    @Id
    @Column
    private int id;

    @Column
    private String houseno;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pincode;

    @OneToOne
    @JoinColumn(name="customer_id")
    Customer customer;
}
