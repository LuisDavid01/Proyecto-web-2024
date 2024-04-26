package com.prueba_Final.service;

import com.prueba_Final.domain.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alonso Muñoz Aguilar
 */
public interface ItemService {

    List<Item> listaItems = new ArrayList<>();

    public List<Item> gets();

    public Item get(Item item);

    public void delete(Item item);

    public void save(Item item);

    public void update(Item item);

    public void facturar();
}
