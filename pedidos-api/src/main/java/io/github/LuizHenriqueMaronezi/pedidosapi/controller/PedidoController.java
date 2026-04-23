package io.github.LuizHenriqueMaronezi.pedidosapi.controller;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroPedidoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Pedido;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
