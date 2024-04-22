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
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
}
//id_usuario INT NOT NULL AUTO_INCREMENT,
//  username VARCHAR(30) NOT NULL,  
//  password varchar(512) NOT NULL, 
// nombre varchar(30) NOT NULL,
// apellidos varchar(30) NOT NULL,
// correo varchar(25) NULL,
// telefono varchar(25) NULL,
//  ruta_imagen varchar(1024),