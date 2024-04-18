package com.Prueba2.service.impl;

import com.Prueba2.dao.ReservasDao;
import com.Prueba2.domain.Reservas;
import com.Prueba2.service.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {

     @Autowired
    private ReservasDao reservaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas() {
        var lista = reservaDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReserva(Reservas reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Reservas reserva) {
        reservaDao.delete(reserva);
    }
}
