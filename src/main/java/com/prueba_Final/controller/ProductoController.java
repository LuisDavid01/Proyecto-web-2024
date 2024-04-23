/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.controller;



import com.prueba_Final.domain.Categoria;
import com.prueba_Final.domain.Producto;
import com.prueba_Final.service.CategoriaService;
import com.prueba_Final.service.FirebaseStorageService;
import com.prueba_Final.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Luis David
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
     @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = productoService.getProductos();
        model.addAttribute("productos", lista);
        return "/producto/listado";
    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    @PostMapping("/guardar")
    public String save(Producto producto
    , @RequestParam("ImageFile") MultipartFile imagenFile){
    if(!imagenFile.isEmpty()){
        productoService.save(producto);
        firebaseStorageService.cargaImagen(imagenFile, "producto", producto.getIdProducto());
    }else{
        System.err.println("no paso imagen");
        }
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model){
        producto=productoService.getProducto(producto);
        model.addAttribute("Producto",producto);
        return "/producto/modifica";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String delete(Producto producto, Model model){
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    
      @GetMapping("/vista/{idProducto}")
    public String vistaProducto(Producto producto, Model model){
        producto=productoService.getProducto(producto);
        model.addAttribute("producto",producto);
        return "/producto/vista";
    }
    
    @GetMapping("/vistaCategoria")
    public String consultaProductoCategoria(@RequestParam(value="idDeCategoria") int idDeCategoria, Model model){
        var lista = productoService.consultaProductoCategoria(idDeCategoria);
        model.addAttribute("productos",lista);
        return "/producto/vistaCategoria";
    }
}
