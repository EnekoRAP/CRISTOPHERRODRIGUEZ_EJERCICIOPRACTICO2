package com.Prueba2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "vuelos")

public class Hoteles implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long id;
    
    @NotEmpty
    private String nombreHotel;
    private String ubicacion;
    private String descripcion;

    @OneToMany
    @JoinColumn(name = "id_hotel", updatable = false)
    List<Reservas> reservas;
    
    public Hoteles() {
    }

    public Hoteles(Long id, String nombreHotel, String ubicacion, String descripcion) {
        this.id = id;
        this.nombreHotel = nombreHotel;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
}
