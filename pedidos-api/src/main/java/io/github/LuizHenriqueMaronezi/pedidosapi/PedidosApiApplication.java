package io.github.LuizHenriqueMaronezi.pedidosapi;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.*;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.enums.TipoCliente;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.CidadeRepository;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.EstadoRepository;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.CategoriaService;
import io.github.LuizHenriqueMaronezi.pedidosapi.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class PedidosApiApplication implements CommandLineRunner {

	private final CategoriaService categoriaService;
	private final ProdutoService produtoService;
	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;

	static void main(String[] args){
		SpringApplication.run(PedidosApiApplication.class, args);
	}

	// Teste
	@Override
	public void run(String... args) throws Exception {

	}
}
