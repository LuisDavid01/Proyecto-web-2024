/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_Final.controller;


import com.prueba_Final.domain.Categoria;
import com.prueba_Final.domain.Producto;
import com.prueba_Final.domain.Promocion;
import com.prueba_Final.service.CategoriaService;
import com.prueba_Final.service.FirebaseStorageService;
import com.prueba_Final.service.ProductoService;
import com.prueba_Final.service.PromocionService;
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
@RequestMapping("/admin")
public class VistaAdminController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private PromocionService promocionService;
    
    @GetMapping("/vista")
    public String listado(Model model){
        var lista = productoService.getProductos();
        model.addAttribute("productos", lista);
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        var promocion = promocionService.getPromocions(false);
        model.addAttribute("promociones", promocion);
        return "/admin/vista";
    }
     @Autowired
    private FirebaseStorageService firebaseStorageService;
     
     // crud producto
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/admin/vista";
    }
    
    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model){
        producto=productoService.getProducto(producto);
        model.addAttribute("producto",producto);
         var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "/admin/modificar";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String delete(Producto producto, Model model){
        productoService.delete(producto);
        return "redirect:/admin/vista";
    }
    
        
    //crud categoria
    @PostMapping("/guardarCategoria")
    public String categoriaGuardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
        return "redirect:/admin/vista";
    }
    
    @GetMapping("/modificarCategoria/{idCategoria}")
    public String categoriaModifica(Categoria categoria, Model model){
        categoria= categoriaService.getCategoria(categoria);
        model.addAttribute("categoria",categoria);
        return "/admin/modificarCategoria";
    }
    
    @GetMapping("/eliminarCategoria/{idCategoria}")
    public String categoriaDelete(Categoria categoria, Model model){
        categoriaService.delete(categoria);
        return "redirect:/admin/vista";
    }
    
    // crud promocion
    
     @PostMapping("/guardarPromocion")
    public String promocionGuardar(Promocion promocion) {        
       promocionService.save(promocion);
        return "redirect:/admin/vista";
    }
    
    @GetMapping("/modificarPromocion/{idPromocion}")
    public String promocionModifica(Promocion promocion, Model model){
        promocion=promocionService.getPromocion(promocion);
        model.addAttribute("promocion",promocion);
        return "/admin/modificarPromocion";
    }
    
    @GetMapping("/eliminarPromocion/{idPromocion}")
    public String PromocionDelete(Promocion promocion, Model model){
        promocionService.delete(promocion);
        return "redirect:/admin/vista";
    }
    
      // crud usuario
    
}
