package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import java.util.List;
import java.util.Set;

public record ClienteDTO(
         String nome,
         String email,
         String cpfOuCnpj,
         Set<String> telefones,
         List<EnderecoDTO> enderecos
) {
}
