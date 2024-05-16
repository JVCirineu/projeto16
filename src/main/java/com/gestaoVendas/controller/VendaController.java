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

import com.gestaoVendas.entities.Venda;
import com.gestaoVendas.service.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class VendaController {
	
private final VendaService VendaService;
	
	@Autowired
	public VendaController (VendaService VendaService) {
		this.VendaService = VendaService;
	}
	
	@GetMapping("/{id}")
	@Operation (summary = "Localiza Venda por ID")
	public ResponseEntity<Venda> buscaVendaControlId(@PathVariable Long id){
		Venda Venda = VendaService.buscaVendaId(id);
		if(Venda != null) {
			return ResponseEntity.ok(Venda);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	@Operation (summary = "Apresenta todos os Venda")
	public ResponseEntity<List<Venda>> buscaTodosVendaControl(){
		List<Venda> Vendas = VendaService.buscaTodosVenda();
		return ResponseEntity.ok(Vendas);
	}
	
	@PostMapping
	@Operation (summary = "Cadastra um Venda")
	public ResponseEntity<Venda> salvaVendaControl(@RequestBody @Valid Venda Venda){
		Venda salvaVenda = VendaService.SalvaVenda(Venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVenda);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Venda> alteraVendaControl(@PathVariable Long id, @RequestBody Venda Venda){
		Venda alterarVenda = VendaService.alterarVenda(id, Venda);
		if(Venda != null) {
			return ResponseEntity.ok(Venda);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarVendaControl(@PathVariable Long id){
		boolean apagar = VendaService.apagarVenda(id);
		if (apagar) {
			return ResponseEntity.ok().body("O 	 foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
