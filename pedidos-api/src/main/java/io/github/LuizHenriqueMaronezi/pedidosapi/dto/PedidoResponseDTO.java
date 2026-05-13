package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Pagamento;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record PedidoResponseDTO(
        UUID id,
        Instant instante,
        PagamentoResponseDTO pagamento,
        ClienteDTO cliente,
        EnderecoDTO enderecoDeEntrega,
        List<ItemPedidoResponseDTO> itens
) {
}
