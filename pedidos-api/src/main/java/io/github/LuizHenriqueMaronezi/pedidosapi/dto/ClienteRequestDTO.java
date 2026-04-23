package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.List;
import java.util.Set;

public record ClienteRequestDTO(
        String nome,
        String email,
        String cpfOuCnpj,
        Set<String> telefones,
        List<EnderecoRequestDTO> enderecos
) {
}