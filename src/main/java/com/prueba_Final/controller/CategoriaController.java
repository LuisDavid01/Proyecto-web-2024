/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.controller;

import com.prueba_Final.domain.Categoria;
import com.prueba_Final.service.CategoriaService;

import com.prueba_Final.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Luis David
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = categoriaService.getCategorias();
        model.addAttribute("categorias", lista);
        return "/categoria/listado";
    }

    @GetMapping("/listado2/{idCategoria}")
    public String modifica(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        var lista = categoria.getProductos();
        model.addAttribute("productos", lista);
        return "/categoria/listado2";
    }
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoService.getProductos();
        model.addAttribute("productos", lista);
        return "/categoria/listado2";
    }

    @PostMapping("/query1")
    public String ConsultaPrecio(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model
    ) {
        var lista = productoService.consultaPrecioProducto(precioInf, precioSup);
        model.addAttribute("productos", lista);
        return "/categoria/listado2";
    }

}
