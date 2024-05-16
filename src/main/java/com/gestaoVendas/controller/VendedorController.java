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

import com.gestaoVendas.entities.Vendedor;
import com.gestaoVendas.service.VendedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class VendedorController {
	
private final VendedorService VendedorService;
	
	@Autowired
	public VendedorController (VendedorService VendedorService) {
		this.VendedorService = VendedorService;
	}
	
	@GetMapping("/{id}")
	@Operation (summary = "Localiza Vendedor por ID")
	public ResponseEntity<Vendedor> buscaVendedorControlId(@PathVariable Long id){
		Vendedor Vendedor = VendedorService.buscaVendedorId(id);
		if(Vendedor != null) {
			return ResponseEntity.ok(Vendedor);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	@Operation (summary = "Apresenta todos os Vendedor")
	public ResponseEntity<List<Vendedor>> buscaTodosVendedorControl(){
		List<Vendedor> Vendedors = VendedorService.buscaTodosVendedor();
		return ResponseEntity.ok(Vendedors);
	}
	
	@PostMapping
	@Operation (summary = "Cadastra um Vendedor")
	public ResponseEntity<Vendedor> salvaVendedorControl(@RequestBody @Valid Vendedor Vendedor){
		Vendedor salvaVendedor = VendedorService.SalvaVendedor(Vendedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVendedor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vendedor> alteraVendedorControl(@PathVariable Long id, @RequestBody Vendedor Vendedor){
		Vendedor alterarVendedor = VendedorService.alterarVendedor(id, Vendedor);
		if(Vendedor != null) {
			return ResponseEntity.ok(Vendedor);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarVendedorControl(@PathVariable Long id){
		boolean apagar = VendedorService.apagarVendedor(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Vendedor foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
