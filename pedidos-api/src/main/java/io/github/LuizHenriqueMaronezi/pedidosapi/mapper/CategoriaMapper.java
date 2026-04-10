package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CategoriaComProdutosDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CategoriaDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface CategoriaMapper {

    Categoria toEntity(CategoriaDTO dto);

    CategoriaComProdutosDTO toDTOComProdutos(Categoria categoria);

    CategoriaDTO toDTO(Categoria categoria);
}
