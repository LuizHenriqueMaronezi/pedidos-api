package io.github.LuizHenriqueMaronezi.pedidosapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "item_pedido",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pedido_id","produto_id"})
})
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double desconto;
    private Integer quantidade;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemPedido(Double desconto, Integer quantidade, BigDecimal preco, Pedido pedido, Produto produto) {
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.pedido = pedido;
        this.produto = produto;
    }

    public ItemPedido(Double desconto, Integer quantidade, BigDecimal preco) {
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemPedido that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
