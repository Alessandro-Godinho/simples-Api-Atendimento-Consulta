package com.desafio.Spdata.desafio.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PacienteDto {
	
	private String nome;
	private String sexo;
	private LocalDate dataNascimento;
	private String gestante;
	private String cpf;

}
