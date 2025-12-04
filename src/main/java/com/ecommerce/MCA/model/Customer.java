package com.ecommerce.MCA.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(length = 10,nullable = false)
    private String phonenumber;

    @CreationTimestamp
    Date createdAt;

    @OneToMany
    @JoinColumn(name="customer_id")
    @JsonIgnore
    List<Review> reviewList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="customer_id")
    @JsonIgnore
    List<Orderentity> orderentityList = new ArrayList<>();
}
