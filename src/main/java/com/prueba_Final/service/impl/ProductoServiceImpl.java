/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.service.impl;


import com.prueba_Final.dao.ProductoDao;
import com.prueba_Final.domain.Producto;
import com.prueba_Final.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis David
 */
@Service
public class ProductoServiceImpl implements ProductoService{
     @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos() {
        var lista = productoDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaPrecioProducto(double precioInf, double precioSup) {
        return productoDao.consultaPrecioProducto(precioInf, precioSup);
    }
    
   
}
