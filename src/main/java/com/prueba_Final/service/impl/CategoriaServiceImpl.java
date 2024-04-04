/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.service.impl;

import com.prueba_Final.dao.CategoriaDao;
import com.prueba_Final.domain.Categoria;
import com.prueba_Final.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis David
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;
    @Override
    public List<Categoria> getCategorias() {
        var lista = categoriaDao.findAll();
        return lista;
    }
    
}
