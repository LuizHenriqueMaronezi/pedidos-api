package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CadastroProdutoDTO(
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 140, message = "Campo fora do tamanho padrão")
        String nome,

        @Positive(message = "O preço não pode ser negativo")
        BigDecimal preco,

        @NotNull(message = "Campo obrigatório")
        List<UUID> idCategorias
) {
}
