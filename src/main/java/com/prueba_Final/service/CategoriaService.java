/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.service;

import com.prueba_Final.domain.Categoria;
import java.util.List;

/**
 *
 * @author Luis David
 */
public interface CategoriaService {
    public List<Categoria> getCategorias();
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
    
}
