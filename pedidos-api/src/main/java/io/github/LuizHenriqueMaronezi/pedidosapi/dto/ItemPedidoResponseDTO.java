package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemPedidoResponseDTO(
        Double desconto,
        Integer quantidade,
        BigDecimal preco,
        ProdutoDTO produto
) {
}
