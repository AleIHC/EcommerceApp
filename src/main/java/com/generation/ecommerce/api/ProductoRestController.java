package com.generation.ecommerce.api;

import com.generation.ecommerce.model.Producto;
import com.generation.ecommerce.service.ProductoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/producto")
public class ProductoRestController {

    private final ProductoServiceImpl productoService;


    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> listaDeProductos() {
        return  new ResponseEntity<>(productoService.listaDeProductos(), HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto nuevoProducto) {
            Producto productoGuardado = productoService.agregarProducto(nuevoProducto); // Guardar producto en la base de datos
            return new ResponseEntity(productoGuardado, HttpStatus.CREATED);

    }


    @PutMapping("/editar/{nombreProducto}")
    public ResponseEntity<Producto> editarProducto(@PathVariable String nombreProducto,
                                                   @RequestBody Producto productoEditado) {

            Producto productoActualizado = productoService.editarProducto(productoEditado, nombreProducto);
            return new ResponseEntity(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{nombreProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String nombreProducto) {
        productoService.eliminarProducto(nombreProducto);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }
}


