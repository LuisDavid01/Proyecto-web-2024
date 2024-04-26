/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.controller;


import com.prueba_Final.domain.Valoracion;
import com.prueba_Final.service.ValoracionService;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Luis David
 */
@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
   
    @Autowired
    private ValoracionService valoracionService;
   
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = valoracionService.getValoracions();
        model.addAttribute("valoraciones", lista);
        return "/valoracion/listado";
    }
    
    @GetMapping("/agregar")
    public String agregar(Model model){
        var lista = valoracionService.getValoracions();
        model.addAttribute("valoraciones", lista);
        return "/valoracion/agregar";
    }
    
    
    @PostMapping("/listado/guardar")
    public String guardar(Model model, Valoracion valoracion){
        valoracion.setFechaValoracion(Calendar.getInstance().getTime());
        valoracionService.save(valoracion);
        return "redirect:/valoracion/listado";
    }
    
    @GetMapping("/listado/eliminar/{idValoracion}")
    public String eliminar(Model model, Valoracion valoracion){
        valoracionService.delete(valoracion);
        return "redirect:/valoracion/listado";
    }
}
