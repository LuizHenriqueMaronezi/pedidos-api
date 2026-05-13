package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.EstadoPagamento;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoResponseDTO(
        UUID id,
        EstadoPagamento estadoPagamento,
        Integer numeroParcelas,
        LocalDate dataVencimento,
        Instant dataPagamento
) {
}
