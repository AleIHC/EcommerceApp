package com.generation.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 20)
    @Column(unique = true)
    private String username;

    @Size(max = 50)
    @Email
    @Column(unique = true)
    private String email;

    @Size(max = 120)
    private String password;

    private String fotoPerfil;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
}
