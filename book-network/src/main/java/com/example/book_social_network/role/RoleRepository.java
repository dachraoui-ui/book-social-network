package com.example.book_social_network.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role ,Integer> {
    Optional<Role> findByName(String role);
}
