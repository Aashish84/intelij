package com.example.demodto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;

    private String firstName;
    private String lastName;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER , optional = false)
    @JoinColumn(name = "location_id")
    private Location location;
}
