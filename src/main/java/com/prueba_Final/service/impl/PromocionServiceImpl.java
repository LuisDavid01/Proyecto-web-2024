/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.service.impl;


import com.prueba_Final.dao.PromocionDao;
import com.prueba_Final.domain.Promocion;
import com.prueba_Final.service.PromocionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis David
 */
@Service
public class PromocionServiceImpl implements PromocionService{
     @Autowired
    private PromocionDao promocionDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Promocion> getPromocions(boolean activo) {
        var lista = promocionDao.findAll();
        if (activo) { 
            lista.removeIf(p -> !p.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Promocion getPromocion(Promocion promocion) {
        return promocionDao.findById(promocion.getIdPromocion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Promocion promocion) {
        promocionDao.save(promocion);
    }

    @Override
    @Transactional
    public void delete(Promocion promocion) {
        promocionDao.delete(promocion);
    }
    

   
}
