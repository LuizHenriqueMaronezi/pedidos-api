package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroProdutoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.mapper.ProdutoMapper;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Produto;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper mapper;

    public Produto salvar(CadastroProdutoDTO dto){

        Produto produto = mapper.toEntity(dto);
        return produtoRepository.save(produto);
    }

}
