package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.List;
import java.util.UUID;

public record  CadastroPedidoDTO(
    UUID clienteId,

    List<ItemPedidoDTO> itens,

    UUID enderecoId,
    EnderecoRequestDTO novoEndereco,

    String tipoPagamento,
    Integer numeroParcelas
) {
}
