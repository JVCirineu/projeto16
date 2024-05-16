package com.gestaoVendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gestaoVendas.entities.Produto;
import com.gestaoVendas.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class ProdutoController {
	
private final ProdutoService ProdutoService;
	
	@Autowired
	public ProdutoController (ProdutoService ProdutoService) {
		this.ProdutoService = ProdutoService;
	}
	
	@GetMapping("/{id}")
	@Operation (summary = "Localiza Produto por ID")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id){
		Produto Produto = ProdutoService.buscaProdutoId(id);
		if(Produto != null) {
			return ResponseEntity.ok(Produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	@Operation (summary = "Apresenta todos os Produto")
	public ResponseEntity<List<Produto>> buscaTodosProdutoControl(){
		List<Produto> Produtos = ProdutoService.buscaTodosProduto();
		return ResponseEntity.ok(Produtos);
	}
	
	@PostMapping
	@Operation (summary = "Cadastra um Produto")
	public ResponseEntity<Produto> salvaProdutoControl(@RequestBody @Valid Produto Produto){
		Produto salvaProduto = ProdutoService.SalvaProduto(Produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto Produto){
		Produto alterarProduto = ProdutoService.alterarProduto(id, Produto);
		if(Produto != null) {
			return ResponseEntity.ok(Produto);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarProdutoControl(@PathVariable Long id){
		boolean apagar = ProdutoService.apagarProduto(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Produto foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
