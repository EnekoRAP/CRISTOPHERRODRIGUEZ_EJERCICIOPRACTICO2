package com.Prueba2.dao;

import com.Prueba2.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository <Usuarios, Long> {
    
    Usuarios findByUsername(String username);
    
    Usuarios findByUsernameAndPassword(String username, String Password);
    
    Usuarios findByUsernameOrCorreo(String username, String Correo);
    
    boolean existsByUsernameOrCorreo(String username, String Correo);
    
}
