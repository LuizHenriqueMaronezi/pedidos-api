package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ClienteDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ClienteRequestDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EnderecoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EnderecoRequestDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cliente;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ClienteMapper {

    public abstract ClienteDTO toDto(Cliente cliente);

    public abstract Cliente toEntity(ClienteDTO dto);

    public abstract Cliente toEntity(ClienteRequestDTO requestDTO);

    public abstract EnderecoDTO toEnderecoDto(Endereco endereco);

    public abstract  Endereco toEntity(EnderecoRequestDTO requestDTO);
}
