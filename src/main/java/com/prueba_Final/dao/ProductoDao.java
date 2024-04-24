/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.dao;


import com.prueba_Final.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Luis David
 */
public interface ProductoDao extends JpaRepository<Producto,Long>{
    
    
//    recupera productos en un rango de precio
    @Query(nativeQuery = true, value="SELECT * FROM producto p WHERE p.precio BETWEEN :precioInf AND :precioSup")
    public List<Producto> consultaPrecioProducto(double precioInf, double precioSup);
    
    
}
