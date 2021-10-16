package com.desafio.Spdata.desafio.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RetornoAtendimentoDto {

	private LocalDateTime duracao;
	private Long idAtendimento;

}
