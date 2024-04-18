package com.Prueba2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuariosDetailsService {
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
