package com.example.demo.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UsuarioRolDao;
import com.example.demo.entity.UsuarioRol;
import com.example.demo.repository.UsuarioRolRepository;

@Component
public class UsuarioRolDaoImpl implements UsuarioRolDao {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public UsuarioRol create(UsuarioRol a) {
        return usuarioRolRepository.save(a);
    }

    @Override
    public UsuarioRol update(UsuarioRol a) {
        return usuarioRolRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        usuarioRolRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioRol> read(Long id) {
        return usuarioRolRepository.findById(id);
    }

    @Override
    public List<UsuarioRol> readAll() {
        return usuarioRolRepository.findAll();
    }
}
