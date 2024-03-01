package com.generation.ecommerce.service;

import com.generation.ecommerce.model.ERol;
import com.generation.ecommerce.model.Rol;
import com.generation.ecommerce.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public Optional<Rol> buscarRolPorNombre(ERol nombre) {
        return rolRepository.findByNombre(nombre);
    }
}

