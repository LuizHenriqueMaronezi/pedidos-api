package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record ClienteDTO(
         UUID id,
         String nome,
         String email,
         String cpfOuCnpj,
         Set<String> telefones,
         List<EnderecoDTO> enderecos
) {
}
