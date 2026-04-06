package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ProdutoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface ProdutoMapper {

    Produto toEntity(ProdutoDTO dto);

    ProdutoDTO toDTO(Produto produto);
}
