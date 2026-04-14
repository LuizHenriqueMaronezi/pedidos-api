package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ClienteDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable UUID id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}
