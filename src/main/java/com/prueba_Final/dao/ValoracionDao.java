/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.dao;


import com.prueba_Final.domain.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luis David
 */
public interface ValoracionDao extends JpaRepository<Valoracion,Long>{
   
}
