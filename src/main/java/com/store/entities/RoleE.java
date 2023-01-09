package com.store.entities;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public RoleE(String name) {
        super();
        this.name = name;
    }

    public RoleE() {

    }
}
