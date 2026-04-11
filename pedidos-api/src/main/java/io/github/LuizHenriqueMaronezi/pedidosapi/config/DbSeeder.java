package io.github.LuizHenriqueMaronezi.pedidosapi.config;

import io.github.LuizHenriqueMaronezi.pedidosapi.model.Cidade;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Estado;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.CidadeRepository;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {

        if (estadoRepository.count() > 0) {
            return;
        }

        Estado saoPaulo = new Estado(null, "São Paulo");
        Estado rioDeJaneiro = new Estado(null, "Rio de Janeiro");
        Estado minasGerais = new Estado(null, "Minas Gerais");

        Cidade limeira = new Cidade(null, "Limeira", saoPaulo);
        Cidade iracema = new Cidade(null, "Iracemápolis", saoPaulo);
        Cidade cordeiro = new Cidade(null, "Cordeirópolis", saoPaulo);

        Cidade niteroi = new Cidade(null, "Niterói", rioDeJaneiro);
        Cidade duque = new Cidade(null, "Duque de Caxias", rioDeJaneiro);
        Cidade buzios = new Cidade(null, "Búzios", rioDeJaneiro);

        Cidade belo = new Cidade(null, "Belo Horizonte", minasGerais);
        Cidade pocos = new Cidade(null, "Poços de Caldas", minasGerais);
        Cidade uber = new Cidade(null, "Uberlândia", minasGerais);

        saoPaulo.getCidades().addAll(Arrays.asList(limeira, iracema, cordeiro));
        rioDeJaneiro.getCidades().addAll(Arrays.asList(niteroi, duque, buzios));
        minasGerais.getCidades().addAll(Arrays.asList(belo, pocos, uber));

        estadoRepository.saveAll(Arrays.asList(saoPaulo, rioDeJaneiro, minasGerais));
    }
}