package com.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class UserE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String username;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles"
            , joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<RoleE> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_user_id",referencedColumnName = "id")
    private DetailUserE detailUserE;

    public UserE(String password, String username, Set<RoleE> authorities) {
        this.password = password;
        this.username = username;
        this.authorities = authorities;
    }

    public UserE() {
    }
}
