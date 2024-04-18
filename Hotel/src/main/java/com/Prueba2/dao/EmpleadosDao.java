package com.Prueba2.dao;

import com.Prueba2.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosDao extends JpaRepository <Empleados, Long> {
    
    Empleados findByName(String nombre);
    
    Empleados findByNameAndLastname(String nombre, String apellidos);
    
    Empleados findByNameAndId(String nombre, int idEmpleado);
    
    Empleados findByUsername(String nombreUsuario);
    
    Empleados findByUsernameAndPassword(String nombreUsuario, String contrasena);

    Empleados findByUsernameOrCedula(String nombreUsuario, String cedula);

    boolean existsByUsernameOrCedula(String nombreUsuario, String cedula);
    
}
