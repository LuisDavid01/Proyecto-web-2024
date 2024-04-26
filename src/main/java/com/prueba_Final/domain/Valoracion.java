/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Luis David
 */
@Data
@Entity
@Table(name="valoracion")
public class Valoracion implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion")
    private long idValoracion;
    private String puntuacion;
    private String comentario;
    @Column(name = "fecha_valoracion")
    private Date fechaValoracion;

    public Valoracion() {
    }

    
    
    public Valoracion(long idValoracion) {
        this.idValoracion = idValoracion;
        this.fechaValoracion=Calendar.getInstance().getTime();
    }
    
  
    
    
}
