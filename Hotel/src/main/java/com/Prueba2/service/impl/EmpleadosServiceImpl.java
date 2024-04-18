package com.Prueba2.service.impl;

import com.Prueba2.dao.RolesDao;
import com.Prueba2.dao.EmpleadosDao;
import com.Prueba2.domain.Roles;
import com.Prueba2.domain.Empleados;
import com.Prueba2.service.EmpleadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class EmpleadosServiceImpl implements EmpleadosService {
    
    @Autowired
    private EmpleadosDao empleadoDao;
    @Autowired
    private RolesDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> getEmpleados() {
        return empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getEmpleados(Empleados empleados) {
        return empleadoDao.findById(empleados.getIdEmpleados()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getClientePorNombre(String nombre) {
        return empleadoDao.findByName(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Empleados getClientePorNombreYApellido(String nombre, String apellidos) {
        return empleadoDao.findByNameAndLastname(nombre, apellidos);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Empleados getClientePorNombreYId(String nombre, int idCliente) {
        return empleadoDao.findByNameAndId(nombre, idCliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Empleados getClientePorUsername(String nombreUsuario) {
        return empleadoDao.findByUsername(nombreUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getClientePorUsernameYPassword(String nombreUsuario, String contrasena) {
        return empleadoDao.findByUsernameAndPassword(nombreUsuario, contrasena);
    }
    
    @Transactional(readOnly = true)
    public Empleados getUsuarioPorUsernameOCorreo(String nombreUsuario, String cedula) {
        return empleadoDao.findByUsernameOrCedula(nombreUsuario, cedula);
    }
    
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String nombreUsuario, String cedula) {
        return empleadoDao.existsByUsernameOrCedula(nombreUsuario, cedula);
    }

    @Override
    @Transactional
    public void save(Empleados empleados, boolean idRolEmp) {
        empleados = empleadoDao.save(empleados);
        if (idRolEmp) {  //Si se está agregando el cliente, se crea el rol por defecto "USER"
            Roles rol = new Roles();
            rol.setNombre("ROLE_CLIENT");
            
            rol.setIdEmpleados(empleados.getIdEmpleados.toString()); //Conversion Long to String
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Empleados empleados) {
        empleadoDao.delete(empleados);
    }

}
