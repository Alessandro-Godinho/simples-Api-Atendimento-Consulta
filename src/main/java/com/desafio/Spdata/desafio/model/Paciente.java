package com.desafio.Spdata.desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PACIENTE")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "CPF")
	private String cpf;
	@Column(name = "DATANASCIMENTO")
	private LocalDate dataNascimento;
	@Column(name = "SEXO")
	private String sexo;
	@Column(name = "GESTANTE")
	private String gestante;
}
