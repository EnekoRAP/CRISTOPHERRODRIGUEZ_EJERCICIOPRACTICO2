package com.Prueba2.dao;

import com.Prueba2.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository <Usuarios, Long> {
    
    Usuarios findByUsername(String nombreUsuario);
    
    Usuarios findByUsernameAndPassword(String nombreUsuario, String contrasena);

    Usuarios findByUsernameOrCorreo(String nombreUsuario, String correo);

    boolean existsByUsernameOrCorreo(String nombreUsuario, String correo);
    
}
