package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CidadeDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cidade;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public abstract class CidadeMapper {

    public abstract Cidade toEntity(CidadeDTO dto);

    public abstract CidadeDTO toDTO(Cidade cidade);
}
