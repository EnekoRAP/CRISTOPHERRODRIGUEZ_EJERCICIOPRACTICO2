package com.Prueba2.domain;

import com.google.type.DateTime;
import jakarta.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="reservas")

public class Reservas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reservas")
    private Long idReserva;
    
    //private Long idPreservas;  ya no se usa por el @manyToOne
    @NotEmpty
    private int idHotel;
    private int idCliente;
    private DateTime fechaIngreso;
    private DateTime fechaSalida;
    private String numeroCedula;

    @ManyToOne
    @JoinColumn(name="id_hotel")
    @JoinColumn(name="id_cliente")
    Reservas reservas;
    
    public Reservas() {
    }

    public Reservas(Long idReserva, int idHotel, int idCliente, DateTime fechaIngreso, DateTime fechaSalida, String numeroCedula) {
        this.idReserva = idReserva;
        this.idHotel = idHotel;
        this.idCliente = idCliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.numeroCedula = numeroCedula;
    }

    public void setIdHotel(int idHotel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getIdReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdCliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
