package com.example.nuevoservice.controller;


import com.example.nuevoservice.entity.NewP;
import com.example.nuevoservice.model.Producto;
import com.example.nuevoservice.service.NewPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/precios")
@CrossOrigin("*")
public class NewPController {


    @Autowired
    NewPService newPService;

    @GetMapping

    public ResponseEntity<List<Producto>> calcularPrecioProducto(){
        List<Producto> productos= newPService.calcularPrecioProducto();
        if(productos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(productos);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<NewP>> getAll(){
        List<NewP> newPList=newPService.getAll();
        if(newPList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(newPList);

    }

    @PostMapping("/save/{id}")
    public ResponseEntity<NewP> save(@PathVariable("id") int id){
        NewP newP=newPService.save(id);
        if(newP==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newP);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<NewP>>saveAll(){
        List<NewP> newPList=newPService.saveAll();
        if(newPList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(newPList);
    }


    @GetMapping("/{id}")
    public String getNombre(@PathVariable("id") int id){
        String name=newPService.getNombre(id);
        return name;
    }

    @GetMapping("/p/{id}")
    public int getPrecio(@PathVariable("id") int id){
        int precio= newPService.getPrecio(id);
        return precio;
    }


}
