/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.service;

import com.prueba_Final.domain.Promocion;
import java.util.List;

/**
 *
 * @author Luis David
 */
public interface PromocionService {
    public List<Promocion> getPromocions();
    
    public Promocion getPromocion(Promocion promocion);
    
    public void save(Promocion promocion);
    
    public void delete(Promocion promocion);
    
}
