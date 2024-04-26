/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.service;

import com.prueba_Final.domain.Valoracion;
import java.util.List;

/**
 *
 * @author Luis David
 */
public interface ValoracionService {
    public List<Valoracion> getValoracions();
    
    public Valoracion getValoracion(Valoracion valoracion);
    
    public void save(Valoracion valoracion);
    
    public void delete(Valoracion valoracion);
    
}
