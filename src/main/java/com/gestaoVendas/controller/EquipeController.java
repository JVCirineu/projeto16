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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoVendas.entities.Equipe;
import com.gestaoVendas.service.EquipeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag (name = "Equipe", description = "API REST DE GERNECIAMENTO DE EQUIPE")
@RestController
@RequestMapping("/equipe")
public class EquipeController {
	
private final EquipeService EquipeService;
	
	@Autowired
	public EquipeController (EquipeService EquipeService) {
		this.EquipeService = EquipeService;
	}
	
	@GetMapping("/{id}")
	@Operation (summary = "Localiza Equipe por ID")
	public ResponseEntity<Equipe> buscaEquipeControlId(@PathVariable Long id){
		Equipe Equipe = EquipeService.buscaEquipeId(id);
		if(Equipe != null) {
			return ResponseEntity.ok(Equipe);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	@Operation (summary = "Apresenta todos os Equipe")
	public ResponseEntity<List<Equipe>> buscaTodosEquipeControl(){
		List<Equipe> Equipes = EquipeService.buscaTodosEquipe();
		return ResponseEntity.ok(Equipes);
	}
	
	@PostMapping
	@Operation (summary = "Cadastra um Equipe")
	public ResponseEntity<Equipe> salvaEquipeControl(@RequestBody @Valid Equipe Equipe){
		Equipe salvaEquipe = EquipeService.SalvaEquipe(Equipe);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaEquipe);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Equipe> alteraEquipeControl(@PathVariable Long id, @RequestBody Equipe Equipe){
		Equipe alterarEquipe = EquipeService.alterarEquipe(id, Equipe);
		if(Equipe != null) {
			return ResponseEntity.ok(Equipe);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarEquipeControl(@PathVariable Long id){
		boolean apagar = EquipeService.apagarEquipe(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Equipe foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

