package io.github.LuizHenriqueMaronezi.pedidosapi.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    private Instant instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente, Endereco enderecoDeEntrega) {
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
}
