package io.github.LuizHenriqueMaronezi.pedidosapi.repository;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
