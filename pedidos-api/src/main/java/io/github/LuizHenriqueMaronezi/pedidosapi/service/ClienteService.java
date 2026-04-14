package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ClienteDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.exceptions.ObjetoNaoEncontradoException;
import io.github.LuizHenriqueMaronezi.pedidosapi.mapper.ClienteMapper;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public List<ClienteDTO> listarTodos(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public ClienteDTO buscarPorId(UUID id){
        var cliente = repository.findById(id).orElseThrow(()
                -> new ObjetoNaoEncontradoException("ID de cliente não encontrada no sistema. ID: " + id));
        return mapper.toDto(cliente);
    }
}
