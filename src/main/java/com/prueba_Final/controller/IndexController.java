/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.controller;
import com.prueba_Final.service.CategoriaService;
import com.prueba_Final.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Luis David
 */
@Controller
@Slf4j

public class IndexController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String listado(Model model) {
        var lista = productoService.getProductos();
        model.addAttribute("productos", lista);
     
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "index";
    }
    
  

}
