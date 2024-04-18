package com.Prueba2.controller;

import com.Prueba2.domain.Hoteles;
import com.Prueba2.service.HotelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hoteles")
public class HotelesController {
    @Autowired
    private HotelesService hotelesService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var hoteles = hotelesService.getHoteles(false);
        model.addAttribute("vuelos", hoteles);
        model.addAttribute("totalVuelos", hoteles.size());
        return "/hoteles/listado";
    }
    
     @GetMapping("/nuevo")
    public String hotelesNuevo(Hoteles hoteles) {
        return "/hoteles/modifica";
    }

    @PostMapping("/guardar")
    public String hotelesGuardar(Hoteles hoteles,
            @RequestParam("ubicacionHotel") String ubicacionHotel) {        
        if (ubicacionHotel != null && !ubicacionHotel.isEmpty()) {
            hotelesService.save(hoteles);
            hoteles.setDescripcion(ubicacionHotel);
        }
        hotelesService.save(hoteles);
        return "redirect:/hoteles/listado";
    }

    @GetMapping("/eliminar/{idHotel}")
    public String hotelesEliminar(Hoteles hoteles) {
        hotelesService.delete(hoteles);
        return "redirect:/hoteles/listado";
    }

    @GetMapping("/modificar/{idHotel}")
    public String hotelesModificar(Hoteles hoteles, Model model) {
        hoteles = hotelesService.getHoteles(hoteles);
        model.addAttribute("vuelos", hoteles);
        return "/vuelos/modifica";
    }   
}
