package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Produto;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> salvarTodos(List<Produto> produtos){
        return produtoRepository.saveAll(produtos);
    }
}
