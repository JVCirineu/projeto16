package com.gestaoVendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoVendas.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	//Query Method
	List<Produto> findByNome (String nome);
	
	List<Produto> findByDescricao (String descricao);

}
