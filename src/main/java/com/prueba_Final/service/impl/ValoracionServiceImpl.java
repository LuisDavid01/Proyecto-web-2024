/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.service.impl;

import com.prueba_Final.dao.ValoracionDao;
import com.prueba_Final.domain.Valoracion;
import com.prueba_Final.service.ValoracionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis David
 */
@Service
public class ValoracionServiceImpl implements ValoracionService{
    @Autowired
    private ValoracionDao valoracionDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Valoracion> getValoracions() {
        var lista = valoracionDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Valoracion getValoracion(Valoracion valoracion) {
        return valoracionDao.findById(valoracion.getIdValoracion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Valoracion valoracion) {
        valoracionDao.save(valoracion);
    }

    @Override
    @Transactional
    public void delete(Valoracion valoracion) {
        valoracionDao.delete(valoracion);
    }
    
}
