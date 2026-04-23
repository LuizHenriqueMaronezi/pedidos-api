package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ClienteDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ClienteRequestDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.exceptions.ObjetoNaoEncontradoException;
import io.github.LuizHenriqueMaronezi.pedidosapi.mapper.ClienteMapper;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cidade;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Endereco;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.TipoCliente;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.CidadeRepository;
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

    private final CidadeRepository cidadeRepository;

    public void salvar(ClienteRequestDTO requestDto){

        var cliente = mapper.toEntity(requestDto);

        if(requestDto.cpfOuCnpj().length()==11){
            cliente.setTipoCliente(TipoCliente.PESSOA_FISICA);

        } else if (requestDto.cpfOuCnpj().length()==14) {
            cliente.setTipoCliente(TipoCliente.PESSOA_JURIDICA);

        } else{
            throw new IllegalArgumentException("O cpf/cnpj deve estar inserido corretamente");
        }

        // Vinculando Cliente e Cidade em cada endereço
        for(int i=0;i<cliente.getEnderecos().size();i++){
            Endereco endereco = cliente.getEnderecos().get(i);
            UUID cidadeId = requestDto.enderecos().get(i).cidadeId();

            endereco.setCliente(cliente);

            if (cidadeId != null) {
                Cidade cidade = cidadeRepository.findById(cidadeId)
                        .orElseThrow(() -> new ObjetoNaoEncontradoException("Cidade não encontrada"));
                endereco.setCidade(cidade);
            }
        }

        repository.save(cliente);
    }

    public List<ClienteDTO> listarTodos(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public ClienteDTO buscarPorId(UUID id){
        var cliente = repository.findById(id).orElseThrow(()
                -> new ObjetoNaoEncontradoException("ID de cliente não encontrada no sistema. ID: " + id));
        return mapper.toDto(cliente);
    }
}
