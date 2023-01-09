package com.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "details_users")
public class DetailUserE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String firstName;
    @Column(length = 150)
    private String lastName;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String address;
    @Column(length = 12)
    private String phone;
    @OneToOne(mappedBy = "detailUserE")
    private UserE userE;
}
