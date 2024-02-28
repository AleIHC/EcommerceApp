package com.generation.ecommerce.service;

import com.generation.ecommerce.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto buscarProducto(String nombreProducto);

    Producto agregarProducto(Producto nuevoProducto);

    List<Producto> listaDeProductos();

    Producto editarProducto(Producto productoEditado, String nombreProducto);

    void eliminarProducto(String nombreProducto);
}
