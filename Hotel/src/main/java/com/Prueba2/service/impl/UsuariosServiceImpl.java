package com.Prueba2.service.impl;

import com.Prueba2.dao.RolesDao;
import com.Prueba2.dao.UsuariosDao;
import com.Prueba2.domain.Roles;
import com.Prueba2.domain.Usuarios;
import com.Prueba2.service.UsuariosService;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosDao usuarioDao;
    
    @Autowired
    private RolesDao rolDao;
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuario(Usuarios usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuarios usuario, int i) {
        usuario.setActivo(1);
        usuario=usuarioDao.save(usuario);
        
    }

    @Override
    @Transactional
    public void delete(Usuarios usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public void save2(Usuarios usuario, int i) {
        usuario.setActivo(1);
        usuario=usuarioDao.save(usuario);
        Long idUsuario = usuario.getIdUsuario(); 
        if (i == 1 && idUsuario != null) { 
        Roles rol = new Roles();
        rol.setNombre("ROLE_USER");
        rol.setIdUsuario(idUsuario);
        rolDao.save(rol); 
        }
    }
}
