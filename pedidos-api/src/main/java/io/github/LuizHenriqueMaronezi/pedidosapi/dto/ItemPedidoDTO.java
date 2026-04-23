package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.UUID;

public record ItemPedidoDTO(
        UUID produtoId,
        Integer quantidade
) {
}
