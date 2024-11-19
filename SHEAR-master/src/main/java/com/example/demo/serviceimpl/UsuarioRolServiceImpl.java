package com.example.demo.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioRolDao;
import com.example.demo.entity.UsuarioRol;
import com.example.demo.service.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    private UsuarioRolDao usuarioRolDao;

    @Override
    public UsuarioRol create(UsuarioRol a) {
        return usuarioRolDao.create(a);
    }

    @Override
    public UsuarioRol update(UsuarioRol a) {
        return usuarioRolDao.update(a);
    }

    @Override
    public void delete(Long id) {
        usuarioRolDao.delete(id);
    }

    @Override
    public Optional<UsuarioRol> read(Long id) {
        return usuarioRolDao.read(id);
    }

    @Override
    public List<UsuarioRol> readAll() {
        return usuarioRolDao.readAll();
    }
}
