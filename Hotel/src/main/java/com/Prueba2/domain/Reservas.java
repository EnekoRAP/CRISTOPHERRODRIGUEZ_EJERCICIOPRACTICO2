package com.Prueba2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="reservas")

public class Reservas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservaid")
    private Long idReserva;
    @Column(name="usuarioid")
    private String idUsuario;
    @Column(name="tipo_habitacion")
    private String cuarto;
    @Column(name="fecha_inicio")
    private String inicio;
    @Column(name="fecha_fin")
    private String fin;

    public Reservas() {
    }

    public Reservas(Long idReserva, String idUsuario, String cuarto, String inicio, String fin) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.cuarto = cuarto;
        this.inicio = inicio;
        this.fin = fin;
    }
}