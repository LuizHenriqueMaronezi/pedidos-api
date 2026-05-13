package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroPedidoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EnderecoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.PagamentoResponseDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.PedidoResponseDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.time.LocalDate;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public abstract class PedidoMapper {

    public abstract Pedido toEntity(CadastroPedidoDTO dto);

    public abstract Endereco toEntity(EnderecoDTO dto);

    public abstract PedidoResponseDTO toDto(Pedido pedido);

    public PagamentoResponseDTO pagamentoToDto(Pagamento pagamento) {
        if (pagamento == null) return null;

        Integer numeroParcelas = null;
        LocalDate dataVencimento = null;
        Instant dataPagamento = null;

        if (pagamento instanceof PagamentoComCartao cartao) {
            numeroParcelas = cartao.getNumeroParcelas();
        } else if (pagamento instanceof PagamentoComBoleto boleto) {
            dataVencimento = boleto.getDataVencimento();
            dataPagamento = boleto.getDataPagamento();
        }

        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getEstadoPagamento(),
                numeroParcelas,
                dataVencimento,
                dataPagamento
        );
    }
}
