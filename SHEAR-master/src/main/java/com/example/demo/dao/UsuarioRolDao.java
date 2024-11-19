package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.UsuarioRol;

public interface UsuarioRolDao {
	UsuarioRol create(UsuarioRol a);
    UsuarioRol update(UsuarioRol a);
    void delete(Long id);
    Optional<UsuarioRol> read(Long id);
    List<UsuarioRol> readAll();
}
