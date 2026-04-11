package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EstadoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Estado;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.EstadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    ResponseEntity<List<EstadoDTO>> listar(){
        return ResponseEntity.ok(estadoService.listarTodos());
    }
}
