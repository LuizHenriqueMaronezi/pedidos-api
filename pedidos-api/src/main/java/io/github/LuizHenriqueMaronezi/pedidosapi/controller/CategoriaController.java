package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CategoriaComProdutosDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CategoriaDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaComProdutosDTO>> listar(){

        return ResponseEntity.ok(categoriaService.pesquisa());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaComProdutosDTO> listarPorId(@PathVariable UUID id){

        return ResponseEntity.ok().body(categoriaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid CategoriaDTO dto){

        categoriaService.salvar(dto);
        return ResponseEntity.ok().build();
    }
}
