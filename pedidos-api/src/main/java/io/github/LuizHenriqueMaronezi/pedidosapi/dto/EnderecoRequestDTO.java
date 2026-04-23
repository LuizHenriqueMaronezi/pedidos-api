package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.UUID;

public record EnderecoRequestDTO(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cep,
        UUID cidadeId
) {
}
