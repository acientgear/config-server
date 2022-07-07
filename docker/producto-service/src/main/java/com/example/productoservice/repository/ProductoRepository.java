package com.example.productoservice.repository;

import com.example.productoservice.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
