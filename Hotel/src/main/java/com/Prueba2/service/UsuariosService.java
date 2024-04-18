package com.Prueba2.service;

import com.Prueba2.domain.Usuarios;
import java.util.List;

public interface UsuariosService {
    
    // Se obtiene un listado de usuarios en un List
    public List<Usuarios> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuarios getUsuario(Usuarios usuario);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuarios getUsuarioPorUsername(String nombreUsuario);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorUsernameYPassword(String nombreUsuario, String contrasena);
    
    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorUsernameOCorreo(String nombreUsuario, String correo);
    
    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo(String nombreUsuario, String correo);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuarios usuario, int idRolUsuario);
    public void save(Usuarios usuario, boolean idRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuarios usuario);
    
}
