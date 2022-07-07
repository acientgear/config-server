package com.example.productoservice.controller;


import com.example.productoservice.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.productoservice.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAll(){
        List<Producto> productos = productoService.getAll();
        if(productos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id")int id){
        Producto producto= productoService.getProductById(id);
        if(producto== null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producto);
    }

    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto producto1=productoService.save(producto);
        if(producto==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/name/{id}")
    public String getName(@PathVariable("id") int id){
        String name=productoService.getNombre(id);
        return name;
    }

    @GetMapping("/precio/{id}")
    public int getPrecio(@PathVariable("id") int id){
        int precio=productoService.getPrecio(id);
        return precio;
    }

}
