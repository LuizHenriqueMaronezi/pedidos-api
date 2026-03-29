package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Optional<Categoria> buscarPorId(UUID id){
        return categoriaRepository.findById(id);
    }
}
