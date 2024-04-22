/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Luis David
 */
@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private long idRol;
    private String nombre;
   @Column(name="id_usuario")
    private long idUsuario;
}
// id_rol INT NOT NULL AUTO_INCREMENT,
//  nombre VARCHAR(30) NOT NULL,
//  id_usuario INT,