package com.Prueba2.controller;

import com.Prueba2.domain.Usuarios;
import com.Prueba2.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuariosService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuarios/listado";
    }

    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuarios usuarios) {
        return "/usuarios/modifica";
    }

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuarios usuarios,
            @RequestParam("correo") String correo) {
        if (correo != null && !correo.isEmpty()) {
            usuarios.setCorreo(correo);
            usuariosService.save(usuarios, false);
        }
        usuariosService.save(usuarios, true);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuarios usuarios) {
        usuariosService.delete(usuarios);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuarios usuarios, Model model) {
        usuarios = usuariosService.getUsuario(usuarios);
        model.addAttribute("usuarios", usuarios);
        return "/usuarios/modifica";
    }
    
}
