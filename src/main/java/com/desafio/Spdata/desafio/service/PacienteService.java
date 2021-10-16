package com.desafio.Spdata.desafio.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.Spdata.desafio.model.Paciente;
import com.desafio.Spdata.desafio.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;
	
	public Paciente salvarPaciente(String nome, String cpf, String dataNascimento, String sexo,
			Boolean gestante) throws Exception {
		
		if(sexo.equals("Masculino") && gestante) {
			throw new Exception("Informação inconsistente");
		}
		
		var paciente = Paciente.builder()
				.cpf(cpf)
				.nome(nome)
				.dataNascimento(LocalDate.parse(dataNascimento,DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.sexo(sexo.equals("Masculino") ? "M" : "F")
				.gestante(gestante ? "S" : "N")
				.build();
		
		return pacienteRepository.save(paciente);
	}

}
