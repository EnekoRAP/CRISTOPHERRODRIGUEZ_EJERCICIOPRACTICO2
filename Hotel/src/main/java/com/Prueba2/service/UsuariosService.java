package com.Prueba2.service;

import com.Prueba2.domain.Usuarios;
import java.util.List;

public interface UsuariosService {

    public List<Usuarios> getUsuarios();
    
    public Usuarios getUsuario(Usuarios usuario);
    
    public Usuarios getUsuarioPorUsername(String username);

    public Usuarios getUsuarioPorUsernameYPassword(String username, String password);
    
    public Usuarios getUsuarioPorUsernameOCorreo(String username, String correo);
    
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
    
    public void save(Usuarios usuario,int i);
   
    public void save2(Usuarios usuario,int i);
    
    public void delete(Usuarios usuario);
    
}
