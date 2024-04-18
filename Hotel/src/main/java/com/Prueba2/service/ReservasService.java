package com.Prueba2.service;

import com.Prueba2.domain.Reservas;
import java.util.List;

public interface ReservasService {

    public List<Reservas> getReservas();

    public Reservas getReserva(Reservas reserva);

    public void save(Reservas reserva);
    
    public void delete(Reservas reserva);
    
}
