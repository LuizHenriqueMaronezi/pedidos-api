package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    //Teste
    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        Categoria cat1 = new Categoria(UUID.randomUUID(),"Adalberto");
        Categoria cat2 = new Categoria(UUID.randomUUID(),"Rodrygo");

        List<Categoria> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Categoria>> listarPorId(@PathVariable UUID id){

        return ResponseEntity.ok().body(categoriaService.buscarPorId(id));
    }
}
