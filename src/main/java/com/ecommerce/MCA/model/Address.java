package com.ecommerce.MCA.model;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="address_details")
@Builder
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    Customer customer;
}
