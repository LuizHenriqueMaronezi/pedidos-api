package io.github.LuizHenriqueMaronezi.pedidosapi.model;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento{

    private LocalDate dataVencimento;
    private Instant dataPagamento;

    public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDate dataVencimento, Instant dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
