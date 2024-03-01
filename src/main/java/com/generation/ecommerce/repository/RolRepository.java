package com.generation.ecommerce.repository;

import com.generation.ecommerce.model.ERol;
import com.generation.ecommerce.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERol nombre);
}
