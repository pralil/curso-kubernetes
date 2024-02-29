package com.pablo.springcloud.msvc.usuarios.msvcusuarios.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pablo.springcloud.msvc.usuarios.msvcusuarios.modules.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    boolean existsByEmail(String email);

}
