package com.store.repositories;

import com.store.entities.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserE,Long> {
    Optional<UserE> findUserByUsername(String username);
    Boolean existsByUsername(String username);
}
