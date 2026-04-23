package io.github.LuizHenriqueMaronezi.pedidosapi.repository;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Endereco;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
