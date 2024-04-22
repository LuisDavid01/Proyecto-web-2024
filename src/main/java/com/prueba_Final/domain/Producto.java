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
@Table(name="producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;
    //private long idCategoria;
    private String nombreProducto;
    private String tallaProducto;
    private double precio;
    private String rutaImagen;
    
   @ManyToOne
   @JoinColumn(name="id_categoria")
   private Categoria categoria;
}
// id_categoria INT NOT NULL AUTO_INCREMENT,
//  nombre_categoria VARCHAR(30) NOT NULL,
//  ruta_imagen varchar(1024),
