/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Luis David
 */
@Data
@Entity
@Table(name="promocion")
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promocion")
    private long idPromocion;
    private String nombre;
    private String descripcion;
    private double descuento;
    private boolean activo;
    
   
}
// id_categoria INT NOT NULL AUTO_INCREMENT,
//  nombre_categoria VARCHAR(30) NOT NULL,
//  ruta_imagen varchar(1024),
