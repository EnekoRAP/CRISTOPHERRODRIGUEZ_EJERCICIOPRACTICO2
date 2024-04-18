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
    private Long id;
    
    //private Long idPreservas;  ya no se usa por el @manyToOne
    @NotEmpty
    private int hotel_id;
    private String cliente_nombre;
    private DateTime fecha_ingreso;
    private DateTime fecha_salida;
    private String numero_cedula;

    @ManyToOne
    @JoinColumn(name="id_hotel")
    @JoinColumn(name="id_cliente")
    Reservas reservas;
    
    public Reservas() {
    }

    public Reservas(Long id, int hotel_id, String cliente_nombre, DateTime fecha_ingreso, DateTime fecha_salida, String numeroCedula) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.cliente_nombre = cliente_nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.numero_cedula = numero_cedula;
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
