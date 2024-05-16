package com.gestaoVendas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Vendedor")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull
	private Long id;
	
	@NotNull
	private double meta;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private double salario;
	
	@NotBlank
	private String setor;
	
	@NotNull
	private double totalVendas;
	
	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
	
}
