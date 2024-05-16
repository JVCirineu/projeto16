package com.gestaoVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoVendas.entities.Vendedor;
import com.gestaoVendas.repository.VendedorRepository;

@Service
public class VendedorService {
	private final VendedorRepository vendedorRepository;
	
	@Autowired
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	

	public List<Vendedor> buscaTodosVendedor(){
		return vendedorRepository.findAll();
	}

	public Vendedor buscaVendedorId(Long id) {
		Optional <Vendedor> Vendedor = vendedorRepository.findById(id);
		return Vendedor.orElse(null);
	}
	
	//query method
	public List<Vendedor> buscarVendedorPorNome(String nome){
		return vendedorRepository.findByNome(nome);
	}
	
	//query method
	public List<Vendedor> buscarVendedorPorSetor(String setor){
		return vendedorRepository.findBySetor(setor);
	}
	
	//metodo salvar os produtos
	public Vendedor SalvaVendedor(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	public Vendedor alterarVendedor(Long id, Vendedor alterarVendedor) {
		Optional <Vendedor> existeVendedor = vendedorRepository.findById(id);

		if (existeVendedor.isPresent()) {
			alterarVendedor.setId(id);
			return vendedorRepository.save(alterarVendedor);
		}
		return null;
	}
	public boolean apagarVendedor(Long id) {
		Optional <Vendedor> existeVendedor = vendedorRepository.findById(id);
		if (existeVendedor.isPresent()) {
			vendedorRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
