package io.github.LuizHenriqueMaronezi.pedidosapi.model;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String cpfOuCnpj;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    @ElementCollection
    @CollectionTable(name="telefone")
    private Set<String> telefones = new HashSet<>();



    public Cliente(String nome, String email, UUID id, String cpfOuCnpj, TipoCliente tipoCliente) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
