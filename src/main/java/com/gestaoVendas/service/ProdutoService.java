package com.gestaoVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoVendas.entities.Produto;
import com.gestaoVendas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	

	public List<Produto> buscaTodosProduto(){
		return produtoRepository.findAll();
	}

	public Produto buscaProdutoId(Long id) {
		Optional <Produto> Produto = produtoRepository.findById(id);
		return Produto.orElse(null);
	}
	//query method
	public List<Produto> buscarProdutoPorNome(String nome){
		return produtoRepository.findByNome(nome);
	}
	
	//query method
		public List<Produto> buscarProdutoPorDescricao(String descricao){
			return produtoRepository.findByDescricao(descricao);
		}
	
	//metodo salvar os produtos
	public Produto SalvaProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto alterarProduto(Long id, Produto alterarProduto) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);

		if (existeProduto.isPresent()) {
			alterarProduto.setId(id);
			return produtoRepository.save(alterarProduto);
		}
		return null;
	}
	public boolean apagarProduto(Long id) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
