/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.service;


import com.prueba_Final.domain.Producto;
import java.util.List;

/**
 *
 * @author Luis David
 */
public interface ProductoService {
    public List<Producto> getProductos();
    
     public Producto getProducto(Producto producto);
    
    public void save(Producto producto);
    
    public void delete(Producto producto);
    
    //    recupera productos en un rango de precio
    public List<Producto> consultaPrecioProducto(double precioInf, double precioSup);
}
