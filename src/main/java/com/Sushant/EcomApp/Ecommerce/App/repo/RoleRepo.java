package com.Sushant.EcomApp.Ecommerce.App.repo;

import com.Sushant.EcomApp.Ecommerce.App.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(String role);
}
