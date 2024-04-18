package com.Prueba2.service;

import com.Prueba2.domain.Usuarios;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;

public interface RegistrosService {
    
    public Model activar(Model model, String usuario, String clave);

    public Model crearUsuario(Model model, Usuarios usuario) throws MessagingException;
    
    public void activar(Usuarios usuario);
    
    public Model recordarUsuario(Model model, Usuarios usuario) throws MessagingException;
    
}
