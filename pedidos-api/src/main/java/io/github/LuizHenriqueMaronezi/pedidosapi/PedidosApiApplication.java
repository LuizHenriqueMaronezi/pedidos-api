package io.github.LuizHenriqueMaronezi.pedidosapi;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Categoria;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Produto;
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

	static void main(String[] args) {
		SpringApplication.run(PedidosApiApplication.class, args);
	}

	// Teste
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null,"Computador", new BigDecimal("2000.00"));
		Produto p2 = new Produto(null, "Impressora", new BigDecimal("800.00"));
		Produto p3 = new Produto(null, "Mouse", new BigDecimal("80.00"));

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaService.salvar(cat1);
		categoriaService.salvar(cat2);

		produtoService.salvarTodos(Arrays.asList(p1,p2,p3));
	}
}
