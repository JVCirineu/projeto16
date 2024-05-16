package com.gestaoVendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoVendas.entities.Vendedor;

public interface  VendedorRepository extends JpaRepository<Vendedor, Long> {
	//Query Method
	List<Vendedor> findByNome (String nome);
	
	List<Vendedor> findBySetor (String setor);
}
