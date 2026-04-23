package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EnderecoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EnderecoRequestDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EnderecoMapper {

    public abstract Endereco toEntity(EnderecoDTO dto);

    public abstract Endereco toEntity(EnderecoRequestDTO requestDTO);
}
