package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroPedidoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.PedidoResponseDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Pedido;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    ResponseEntity<Void> salvar(@RequestBody @Valid CadastroPedidoDTO dto){
        service.salvar(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable UUID id){

        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
}
