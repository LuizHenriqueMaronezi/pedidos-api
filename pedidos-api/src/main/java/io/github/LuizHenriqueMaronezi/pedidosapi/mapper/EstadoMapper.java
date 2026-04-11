package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CidadeDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EstadoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cidade;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Estado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EstadoMapper {

    public abstract Estado toEntity(EstadoDTO dto);

    public abstract EstadoDTO toDTO(Estado estado);

    public abstract CidadeDTO toCidadeDTO(Cidade cidade);
}
