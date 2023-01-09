package com.store.repositories;

import com.store.entities.RoleE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleE,Long> {
    Optional<RoleE> findByName(String name);
}
