package com.example.nuevoservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int precio;
    private int usd;
    private int eur;

    public NewP(String nombre,int precio) {
        this.nombre = nombre;
        this.precio=precio;
        this.eur=precio/977;
        this.usd=precio/970;
    }
}
