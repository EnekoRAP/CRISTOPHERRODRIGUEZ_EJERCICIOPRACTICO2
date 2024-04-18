package com.Prueba2.controller;

import com.Prueba2.domain.Reservas;
import com.Prueba2.service.HotelesService;
import com.Prueba2.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservas")
public class ReservasController {
  
    @Autowired
    private ReservasService reservasService;
    @Autowired
    private HotelesService hotelesService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var reservas = reservasService.getReservas(false);
        model.addAttribute("reservas", reservas);
        
        var vuelos = hotelesService.getHoteles(false);
        model.addAttribute("hoteles", hoteles);
        
        model.addAttribute("totalReservas",reservas.size());
        return "/reservas/listado";
    }
    
     @GetMapping("/nuevo")
    public String reservasNuevo(Reservas reservas) {
        return "/reservas/modifica";
    }
    
    @PostMapping("/guardar")
    public String reservasGuardar(Reservas reservas,
            @RequestParam("idHotel") int idHotel,
            @RequestParam("idEmpleado") int idEmpleado) {
        if (idHotel != 0 && idEmpleado != 0) {
            reservasService.save(reservas);
            reservas.setIdHotel(idHotel, 
                    reservas.getIdReserva());
            reservas.setIdCliente(idEmpleado,
                    reservas.getIdReserva());
        }
        reservasService.save(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/eliminar/{idReserva}")
    public String rereservasEliminar(Reservas reservas) {
        reservasService.delete(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String reservasModificar(Reservas reservas, Model model) {
        reservas = reservasService.getReserva(reservas);
        model.addAttribute("reservas", reservas);
        
        var hoteles = hotelesService.getHoteles(false);
        model.addAttribute("hoteles", hoteles);
        
        return "/rereservas/modifica";
    }   
    
}
