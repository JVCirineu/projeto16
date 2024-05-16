package com.gestaoVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoVendas.entities.Equipe;
import com.gestaoVendas.repository.EquipeRepository;

@Service
public class EquipeService {

	
	private final EquipeRepository equipeRepository;
		
		@Autowired
		public EquipeService(EquipeRepository equipeRepository) {
			this.equipeRepository = equipeRepository;
		}
		

		public List<Equipe> buscaTodosEquipe(){
			return equipeRepository.findAll();
		}

		public Equipe buscaEquipeId(Long id) {
			Optional <Equipe> Equipe = equipeRepository.findById(id);
			return Equipe.orElse(null);
		}
		//query method
		public List<Equipe> buscarEquipePorCidade(String cidade){
			return equipeRepository.findByCidade(cidade);
		}
		//query method
				public List<Equipe> buscarEquipePorEmail(String email){
					return equipeRepository.findByEmail(email);
				}
		
		//metodo salvar as Equipe
		public Equipe SalvaEquipe(Equipe equipe) {
			return equipeRepository.save(equipe);
		}
		public Equipe alterarEquipe(Long id, Equipe alterarEquipe) {
			Optional <Equipe> existeEquipe = equipeRepository.findById(id);

			if (existeEquipe.isPresent()) {
				alterarEquipe.setId(id);
				return equipeRepository.save(alterarEquipe);
			}
			return null;
		}
		public boolean apagarEquipe(Long id) {
			Optional <Equipe> existeEquipe= equipeRepository.findById(id);
			if (existeEquipe.isPresent()) {
				equipeRepository.deleteById(id);
				return true;
			}
			return false;
		}

}
