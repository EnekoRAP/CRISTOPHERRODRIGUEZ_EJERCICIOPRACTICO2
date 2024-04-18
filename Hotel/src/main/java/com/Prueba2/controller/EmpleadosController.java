package com.Prueba2.controller;

import com.Prueba2.domain.Empleados;
import com.Prueba2.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var clientes = empleadosService.getEmpleados();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalEmpleados", clientes.size());
        return "/empleado/listado";
    }

    @GetMapping("/nuevo")
    public String empleadoNuevo(Empleados empleado) {
        return "/empleado/modifica";
    }

    @PostMapping("/guardar")
    public String empleadoGuardar(Empleados empleado,
            @RequestParam("cargo") String cargo) {
        if (cargo != null && !cargo.isEmpty()) {
            empleado.setCargo(cargo);
            empleadosService.save(empleado, false);
        }
        empleadosService.save(empleado, true);
        return "redirect:/empleado/listado";
    }

    @GetMapping("/eliminar/{idEmpleado}")
    public String empleadoEliminar(Empleados empleado) {
        empleadosService.delete(empleado);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/modificar/{idEmpleado}")
    public String empleadoModificar(Empleados empleado, Model model) {
        empleado = empleadosService.getEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "/empleado/modifica";
    }
    
}
