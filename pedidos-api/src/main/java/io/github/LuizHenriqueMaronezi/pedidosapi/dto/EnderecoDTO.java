package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.UUID;

public record EnderecoDTO(
        UUID id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cep
) {
}
