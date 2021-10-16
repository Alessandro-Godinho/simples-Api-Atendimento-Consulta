package com.desafio.Spdata.desafio.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EncerramentoDto {

	private LocalDateTime dataHoraEncerramento;
	private Long idAtendimento;

}
