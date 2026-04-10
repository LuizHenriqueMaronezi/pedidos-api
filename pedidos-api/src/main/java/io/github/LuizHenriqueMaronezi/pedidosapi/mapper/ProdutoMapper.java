package io.github.LuizHenriqueMaronezi.pedidosapi.mapper;

import io.github.LuizHenriqueMaronezi.pedidosapi.dto.CadastroProdutoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ProdutoComCategoriaDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.dto.ProdutoDTO;
import io.github.LuizHenriqueMaronezi.pedidosapi.model.Produto;
import io.github.LuizHenriqueMaronezi.pedidosapi.repository.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = CategoriaMapper.class)
public abstract class ProdutoMapper {

    @Autowired
    protected CategoriaRepository categoriaRepository;

    @Mapping(target = "categorias", expression =
        "java( categoriaRepository.findAllById(dto.idCategorias()) )")
    public abstract Produto toEntity(CadastroProdutoDTO dto);

    public abstract ProdutoComCategoriaDTO toDTOComCategoria(Produto produto);

    public abstract ProdutoDTO toDTO(Produto produto);
}
