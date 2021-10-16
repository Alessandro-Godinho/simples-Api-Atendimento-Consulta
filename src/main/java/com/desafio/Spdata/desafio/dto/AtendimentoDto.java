package com.desafio.Spdata.desafio.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AtendimentoDto {
	
	private LocalDateTime dataAtendimento;
	private String dianostico;
	private String Descricaosituacao; 
	private Long idPaciente;

}
