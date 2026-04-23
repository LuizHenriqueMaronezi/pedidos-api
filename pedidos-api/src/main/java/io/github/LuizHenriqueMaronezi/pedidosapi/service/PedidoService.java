package io.github.LuizHenriqueMaronezi.pedidosapi.service;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroPedidoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ItemPedidoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.exceptions.ObjetoNaoEncontradoException;
import io.github.LuizHenriqueMaronezi.pedidosapi.mapper.EnderecoMapper;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.*;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.EstadoPagamento;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CidadeRepository cidadeRepository;

    private final EnderecoMapper enderecoMapper;

    @Transactional
    public void salvar(CadastroPedidoDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Cliente não encontrado"));

        Endereco endereco;
        if(dto.enderecoId() == null) {
            Cidade cidade = cidadeRepository.findById(dto.novoEndereco().cidadeId())
                    .orElseThrow(() -> new ObjetoNaoEncontradoException("Cidade não encontrada"));
            endereco = enderecoMapper.toEntity(dto.novoEndereco());

            endereco.setCliente(cliente);
            endereco.setCidade(cidade);

            enderecoRepository.save(endereco);

        } else if (dto.novoEndereco()==null) {
            endereco = enderecoRepository.findById(dto.enderecoId())
                    .orElseThrow(() -> new ObjetoNaoEncontradoException("Endereco não encontrado"));

        } else{
            throw new IllegalArgumentException("O endereço do pedido não foi enviado corretamente");
        }

        Pedido pedido = new Pedido(cliente,endereco);

        for(ItemPedidoDTO item : dto.itens()){
            Produto produto = produtoRepository.findById(item.produtoId())
                    .orElseThrow(() -> new ObjetoNaoEncontradoException("Produto não encontrado"));

            ItemPedido itemPedido = new ItemPedido(0.0,item.quantidade(),produto.getPreco(),pedido,produto);

            pedido.getItens().add(itemPedido);
        }

        Pagamento pagamento;
        if("CARTAO".equalsIgnoreCase(dto.tipoPagamento())){
            pagamento = new PagamentoComCartao(EstadoPagamento.PENDENTE,pedido,dto.numeroParcelas());
        }else if("BOLETO".equalsIgnoreCase(dto.tipoPagamento())){
            pagamento = new PagamentoComBoleto(EstadoPagamento.PENDENTE, pedido, LocalDate.now().plusDays(7),null);
        }else{
            throw new IllegalArgumentException("O pagamento não foi enviado corretamente: Deve ser 'CARTAO' ou 'BOLETO'");
        }

        pedido.setPagamento(pagamento);

        repository.save(pedido);
    }
}
