package com.gestaoVendas.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoVendas.entities.Venda;
import com.gestaoVendas.repository.VendaRepository;

@Service
public class VendaService { 
	private final VendaRepository vendaRepository;
	@Autowired
	public VendaService(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}
	

	public List<Venda> buscaTodosVenda(){
		return vendaRepository.findAll();
	}

	public Venda buscaVendaId(Long id) {
		Optional <Venda> Venda = vendaRepository.findById(id);
		return Venda.orElse(null);
	}
	//query method
	public List<Venda> buscarVendaPorData(Date data){
		return vendaRepository.findByData(data);
	}
	
	//metodo salvar as Equipe
	public Venda SalvaVenda(Venda equipe) {
		return vendaRepository.save(equipe);
	}
	public Venda alterarVenda(Long id, Venda alterarVenda) {
		Optional <Venda> existeVenda = vendaRepository.findById(id);

		if (existeVenda.isPresent()) {
			alterarVenda.setId(id);
			return vendaRepository.save(alterarVenda);
		}
		return null;
	}
	public boolean apagarVenda(Long id) {
		Optional <Venda> existeVenda= vendaRepository.findById(id);
		if (existeVenda.isPresent()) {
			vendaRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
