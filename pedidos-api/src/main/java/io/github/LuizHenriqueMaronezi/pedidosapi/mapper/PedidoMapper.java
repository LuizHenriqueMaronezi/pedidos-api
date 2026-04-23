package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroPedidoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EnderecoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Endereco;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public abstract class PedidoMapper {

    public abstract Pedido toEntity(CadastroPedidoDTO dto);

    public abstract Endereco toEntity(EnderecoDTO dto);
}
