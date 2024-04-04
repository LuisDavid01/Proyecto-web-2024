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

/**
 *
 * @author Luis David
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoDao productoDao;
    @Override
    public List<Producto> getProductos() {
        var lista = productoDao.findAll();
        return lista;
    }
    
}
