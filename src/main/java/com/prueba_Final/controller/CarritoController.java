package com.prueba_Final.controller;

import com.prueba_Final.domain.Item;
import com.prueba_Final.domain.Producto;
import com.prueba_Final.service.ItemService;
import com.prueba_Final.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {


    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregar(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null)
        {
            Producto p = productoService.getProducto(item);
            item2 = new Item(p);
        }
        itemService.save(item2);

        var lista = itemService.gets();
        var listaTotal = 0;
        var carritoTotal = 0;
        for (Item i : lista)
        {
            listaTotal += i.getCantidad();
            carritoTotal += i.getCantidad() * i.getPrecio();
        }

        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", listaTotal);
        model.addAttribute("carritoTotal", carritoTotal);

        return new ModelAndView("/carrito/fragmento :: verCarrito");
    }

    @GetMapping("/carrito/listado")
    public String listado(Model model) {

        var lista = itemService.gets();
        var listaTotal = 0;
        var carritoTotal = 0;
        for (Item i : lista)
        {
            listaTotal += i.getCantidad();
            carritoTotal += i.getCantidad() * i.getPrecio();
        }

        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", listaTotal);
        model.addAttribute("carritoTotal", carritoTotal);

        return "/carrito/listado";
    }

    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminar(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificar(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modifica";
    }

    @PostMapping("/carrito/guardar")
    public String modificar(Item item) {
        itemService.update(item);
        return "redirect:/carrito/listado";
    }
    
    @GetMapping("/facturar/carrito")
    public String facturar() {
       //Aca va el codigo
       itemService.facturar();
        return "redirect:/";
    }
}
