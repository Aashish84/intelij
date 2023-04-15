package com.example.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private List<OrderItem> orderItems;
}


//    @OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY)
//    private List<OrderItem> orderItems;
// one customer can have many order but orders will not be same for another customer

// join column but no column in other side
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private List<OrderItem> orderItems;
