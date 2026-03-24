package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        Categoria cat1 = new Categoria(UUID.randomUUID(),"Adalberto");
        Categoria cat2 = new Categoria(UUID.randomUUID(),"Rodrygo");

        List<Categoria> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);

        return ResponseEntity.ok(list);
    }
}
