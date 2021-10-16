package com.desafio.Spdata.desafio.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.Spdata.desafio.dto.AtendimentoDto;
import com.desafio.Spdata.desafio.dto.EncerramentoDto;
import com.desafio.Spdata.desafio.dto.RetornoAtendimentoDto;
import com.desafio.Spdata.desafio.model.Atendimento;
import com.desafio.Spdata.desafio.model.Situacao;
import com.desafio.Spdata.desafio.repository.AtendimentoRepository;
import com.desafio.Spdata.desafio.repository.PacienteRepository;
import com.desafio.Spdata.desafio.repository.SituacaoRepository;

@Service
public class AtendimentoService {

	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	AtendimentoRepository atendimentoRepository;	
	@Autowired
	SituacaoRepository situacaoRepository;
	
	public Long salvarAtendimento(AtendimentoDto dto) throws Exception {
		
		var paciente = pacienteRepository.findById(dto.getIdPaciente());
		
		if(paciente == null) {
			throw new Exception("Paciente Inexistente");
		}
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

		//String dataAtendimento = dto.getDataAtendimento().format(formatter);
						
		 var situacao = situacaoRepository.save(Situacao.builder().descricao(dto.getDescricaosituacao()).build());
		
		 var atendimento = atendimentoRepository.save(Atendimento.builder()
					.dataAtendimento(dto.getDataAtendimento())
					.dianostico(dto.getDianostico())
					.situacao(situacao)
					.paciente(paciente.get())
					.build());
		 
		 return atendimento.getId();
	}


	public RetornoAtendimentoDto encerrarAtendimento(EncerramentoDto encerramento) throws Exception {
		
		var atendimento = atendimentoRepository.findById(encerramento.getIdAtendimento());
		
		if(atendimento == null) {
			throw new Exception("Atendimento Inexistente");
		}
		
		LocalDateTime duracao = encerramento.getDataHoraEncerramento().minusMinutes(atendimento.get().getDataAtendimento().getMinute());
		
		var resultado = atendimentoRepository.save(Atendimento.builder()
				.id(atendimento.get().getId())
				.dataAtendimento(atendimento.get().getDataAtendimento())
				.dianostico(atendimento.get().getDianostico())
				.situacao(atendimento.get().getSituacao())
				.paciente(atendimento.get().getPaciente())
				.dataHoraEncerramento(encerramento.getDataHoraEncerramento())
				.duracao(duracao)
				.build());
		
		return RetornoAtendimentoDto.builder()
				.idAtendimento(resultado.getId())
				.duracao(duracao)
				.build();
	}

}
