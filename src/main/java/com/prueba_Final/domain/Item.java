package com.prueba_Final.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Alonso Muñoz Aguilar
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Producto {

    private int cantidad;

    public Item(Producto p) {
        super.setCategoria(p.getCategoria());
        super.setDetalle(p.getDetalle());
        super.setExistencias(p.getExistencias());
        super.setIdProducto(p.getIdProducto());
        super.setNombreProducto(p.getNombreProducto());
        super.setPrecio(p.getPrecio());
        super.setRutaImagen(p.getRutaImagen());
        super.setTallaProducto(p.getTallaProducto());
        this.cantidad = 0;
    }
}
