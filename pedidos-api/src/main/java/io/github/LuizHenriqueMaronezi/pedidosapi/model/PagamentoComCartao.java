package io.github.LuizHenriqueMaronezi.pedidosapi.model;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento{

    private Integer numeroParcelas;

    public PagamentoComCartao(UUID id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
