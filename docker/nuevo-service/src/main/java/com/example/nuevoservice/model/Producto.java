package com.example.nuevoservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private String nombre;
    private int precio;

    public int getPrecioUsd() {
        return precio*927;
    }
    public int getPrecioEur(){
        return precio*967;
    }
}
