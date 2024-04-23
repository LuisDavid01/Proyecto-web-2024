/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.dao;


import com.prueba_Final.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Luis David
 */
public interface ProductoDao extends JpaRepository<Producto,Long>{
//    SELECT p.* FROM  yellow_men_store.producto p,  yellow_men_store.categoria c WHERE p.id_categoria = c.id_categoria
     @Query(nativeQuery=true,value=" SELECT p.* FROM  yellow_men_store.producto p WHERE p.id_categoria = :idDeCategoria")
    public List<Producto> consultaProductoCategoria(int idDeCategoria);
    
    
}
