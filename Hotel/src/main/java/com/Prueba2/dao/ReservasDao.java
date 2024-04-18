package com.Prueba2.dao;

import com.Prueba2.domain.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasDao extends JpaRepository <Reservas, Long> {
    
}
