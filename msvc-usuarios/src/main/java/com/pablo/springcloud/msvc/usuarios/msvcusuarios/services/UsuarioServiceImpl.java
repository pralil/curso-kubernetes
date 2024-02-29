package com.pablo.springcloud.msvc.usuarios.msvcusuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablo.springcloud.msvc.usuarios.msvcusuarios.clients.CursoClientRest;
import com.pablo.springcloud.msvc.usuarios.msvcusuarios.modules.entities.Usuario;
import com.pablo.springcloud.msvc.usuarios.msvcusuarios.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private CursoClientRest client;


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }


    @SuppressWarnings("null")
    @Override
    @Transactional
    public Optional<Usuario> delete(Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        usuarioOptional.ifPresent(usuarioDb -> {
            repository.delete(usuarioDb);
            client.eliminarCursoUsuario(usuarioDb.getId());
        });
        return usuarioOptional;
    }

    @Override
    @Transactional(readOnly = true)    
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @SuppressWarnings("null")
    @Override
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return (List<Usuario>) repository.findAllById(ids);
    }


}
