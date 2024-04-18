package com.Prueba2.dao;

import com.Prueba2.domain.Reservas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservasDao extends JpaRepository <Reservas, Long> {
    
    //Ejemplo de método utilizando Métodos de Query
    public List<Reservas> findByIdBetweenOrderByDescripcion(int idHotel, int idEmpleado);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM reservas a where a.id BETWEEN :idHotel AND :idEmpleado ORDER BY a.descripcion ASC")
    public List<Reservas> metodoJPQL(@Param("idHotel") int idHotel, @Param("idEmpleado") int idEmpleado);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM reservas where prereservas.id BETWEEN :idHotel AND :idEmpleado ORDER BY reservas.descripcion ASC")
    public List<Reservas> metodoNativo(@Param("idHotel") int idHotel, @Param("idEmpleado") int idEmpleado);

}
