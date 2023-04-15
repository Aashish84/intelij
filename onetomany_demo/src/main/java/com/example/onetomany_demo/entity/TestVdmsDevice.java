package com.example.onetomany_demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class TestVdmsDevice {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String deviceId;
    private String deviceName;
    private String deviceType;
    @OneToMany
    @JoinColumn(name = "deviceId")
    private List<Connection> connections;
}
