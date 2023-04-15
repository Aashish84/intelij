package com.example.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transportType;
    @Column(name = "customer_id")
    private Long customerId;
}

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="customer_id")
//    private Customer customer;
