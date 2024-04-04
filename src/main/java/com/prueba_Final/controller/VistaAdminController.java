/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.controller;


import com.prueba_Final.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Luis David
 */
@Controller
@RequestMapping("/admin")
public class VistaAdminController {
    @Autowired
    private ProductoService ProductoService;
    
    @GetMapping("/vista")
    public String listado(Model model){
        var lista = ProductoService.getProductos();
        model.addAttribute("productos", lista);
        return "/admin/vista";
    }
    
    
}
