package io.github.LuizHenriqueMaronezi.pedidosapi.dto;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProdutoDTO(
        UUID id,

        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 140, message = "Campo fora do tamanho padrão")
        String nome,

        @Positive(message = "O preço não pode ser negativo")
        BigDecimal preco,

        List<Categoria> categorias
) {
}
