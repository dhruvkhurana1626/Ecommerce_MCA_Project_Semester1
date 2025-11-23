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

public class Orderentity {

    @Id
    @Column
    int id;

    @Column
    int value;

    @Column
    @Enumerated(value = EnumType.STRING)
    Orderstatus orderstatus;

    @ManyToMany
    List<Product> products = new ArrayList<>();

}
