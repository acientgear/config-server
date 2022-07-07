package com.example.productoservice.service;


import com.example.productoservice.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.productoservice.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productorepository;

    public List<Producto> getAll(){
        return productorepository.findAll();
    }

    public Producto getProductById(int id){
        return productorepository.findById(id).orElse(null);

    }

    public Producto save(Producto producto){
        Producto nuevoProducto=productorepository.save(producto);
        return nuevoProducto;
    }

    public String getNombre(int id ){
        return getProductById(id).getNombre();

    }

    public int getPrecio(int id){
        return  getProductById(id).getPrecio();
    }
}
