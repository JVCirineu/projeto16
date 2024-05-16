package com.gestaoVendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoVendas.entities.Equipe;

public interface  EquipeRepository extends JpaRepository<Equipe, Long> {
	//Query Method
	List<Equipe> findByCidade (String cidade);
	
	List<Equipe> findByEmail (String email);


}
