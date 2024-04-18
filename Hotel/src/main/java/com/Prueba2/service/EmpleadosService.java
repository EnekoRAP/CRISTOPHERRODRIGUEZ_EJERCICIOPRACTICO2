package com.Prueba2.service;

import com.Prueba2.domain.Empleados;
import java.util.List;

public interface EmpleadosService {
    
    // Se obtiene un listado de clientes en un List
    public List<Empleados> getEmpleados();
    
    // Se obtiene un Cliente, a partir del id de un cliente
    public Empleados getEmpleados(Empleados empleados);
    
    // Se obtiene un Cliente, a partir del nombre de un cliente
    public Empleados getEmpleadosPorNombre(String nombre);
    
    // Se obtiene un Cliente, a partir del nombre y apellido de un cliente
    public Empleados getEmpleadosPorNombreYApellido(String nombre, String apellidos);
    
    // Se obtiene un Cliente, a partir del nombre y id de un cliente
    public Empleados getClientePorNombreYId(String nombre, int idCliente);
    
    // Se obtiene un Cliente, a partir del username de un cliente
    public Empleados getClientePorUsername(String nombreUsuario);

    // Se obtiene un Cliente, a partir del username y el password de un cliente
    public Empleados getClientePorUsernameYPassword(String nombreUsuario, String contrasena);
    
    // Se obtiene un Cliente, a partir del username y el password de un cliente
    public Empleados getClientePorUsernameOCorreo(String nombreUsuario, String correo);
    
    // Se valida si existe un Cliente considerando el username
    public boolean existeClientePorUsernameOCorreo(String nombreUsuario, String correo);
    
    // Se inserta un nuevo cliente si el id del cliente esta vacío
    // Se actualiza un cliente si el id del cliente NO esta vacío
    public void save(Empleados cliente, int idRolCliente);
    public void save(Empleados cliente, boolean idRolClient);
    
    // Se elimina el cliente que tiene el id pasado por parámetro
    public void delete(Empleados cliente);
    
}
