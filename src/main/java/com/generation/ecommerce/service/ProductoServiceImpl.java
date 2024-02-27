package com.generation.ecommerce.service;

import com.generation.ecommerce.model.Producto;
import com.generation.ecommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto agregarProducto(Producto nuevoProducto) {
        return productoRepository.save(nuevoProducto);
    }

    @Override
    public List<Producto> listaDeProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto editarProducto(Producto productoEditado, String nombreProducto) {
        Producto productoParaEditar = productoRepository.findProductoByNombre(nombreProducto);
        productoEditado.setId(productoParaEditar.getId());
        return productoRepository.save(productoEditado);
    }

    @Override
    public void eliminarProducto(String nombreProducto) {
        productoRepository.deleteProductoByNombre(nombreProducto);
    }








}
