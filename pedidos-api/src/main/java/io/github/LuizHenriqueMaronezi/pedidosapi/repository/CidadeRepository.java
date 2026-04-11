package io.github.LuizHenriqueMaronezi.pedidosapi.repository;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, UUID> {
}
