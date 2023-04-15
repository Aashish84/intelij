package com.example.onetomany_demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long connectionId;
    private String resourceType;
    private String connectionType;
    private String deviceId;
    @ManyToOne
    @JoinColumn(name = "resourceId")
    private TestVdmsDevice resourceId; //target id
}
