package com.pablo.springcloud.msvc.usuarios.msvcusuarios.services;

import java.util.List;
import java.util.Optional;

import com.pablo.springcloud.msvc.usuarios.msvcusuarios.modules.entities.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    Optional<Usuario> delete(Long id);
    List<Usuario> listarPorIds(Iterable<Long> ids);

    boolean existsByEmail(String email);
 
}
