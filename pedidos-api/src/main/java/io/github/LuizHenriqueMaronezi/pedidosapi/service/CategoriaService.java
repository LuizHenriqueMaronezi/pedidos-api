package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CategoriaDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.exceptions.ObjetoNaoEncontradoException;
import io.github.LuizHenriqueMaronezi.pedidosapi.mapper.CategoriaMapper;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper mapper;

    public List<CategoriaDTO> pesquisa(){
        return categoriaRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    public CategoriaDTO buscarPorId(UUID id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()
                -> new ObjetoNaoEncontradoException("ID de categoria não encontrada no sistema. ID: " + id));

        return mapper.toDTO(categoria);
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
