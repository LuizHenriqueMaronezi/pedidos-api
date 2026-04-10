package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroProdutoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ProdutoComCategoriaDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    ResponseEntity<Void> salvar(@RequestBody @Valid CadastroProdutoDTO dto){

        produtoService.salvar(dto);

        return ResponseEntity.ok().build();
    }
}
