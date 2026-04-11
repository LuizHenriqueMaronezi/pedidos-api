package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.EstadoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.mapper.EstadoMapper;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Estado;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final EstadoMapper mapper;

    public List<EstadoDTO> listarTodos(){
        return estadoRepository.findAll().stream().map(mapper::toDTO).toList();
    }
}
