package com.example.nuevoservice.service;


import com.example.nuevoservice.entity.NewP;
import com.example.nuevoservice.model.Producto;
import com.example.nuevoservice.repository.NewPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewPService {

    @Autowired
    NewPRepository newPRepository;

    @Autowired
    RestTemplate restTemplate;


    public List<NewP> getAll(){
        return newPRepository.findAll();
    }

    public NewP save(int id ){
        String nombre=restTemplate.getForObject("http://localhost:8082/productos/name/"+id,String.class);
        int precio=restTemplate.getForObject("http://localhost:8082/productos/precio/"+id,int.class);
        NewP newP=new NewP(nombre,precio);
        NewP newP1=newPRepository.save(newP);
        return newP;
    }

    public NewP save(NewP newP){
        NewP newP1=newPRepository.save(newP);
        return newP;
    }

    public List<NewP> saveAll(){
        List<Producto> productos=calcularPrecioProducto();
        List<NewP> newPList = new ArrayList<>();
        for(int i=1;i<productos.size()+1;i++){
            newPList.add(save(i));

        }
        return newPList;
    }

    public List<Producto> calcularPrecioProducto(){
        List<Producto> productos=restTemplate.getForObject("http://localhost:8082/productos",List.class);
        return productos;


    }

    public String getNombre(int id){
        String name=restTemplate.getForObject("http://localhost:8082/productos/name/"+id,String.class);
        return name;
    }

    public int getPrecio(int id){
        int precio=restTemplate.getForObject("http://localhost:8082/productos/precio/"+id,int.class);
        return precio;
    }

}
