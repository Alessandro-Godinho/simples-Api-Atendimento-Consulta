package com.desafio.Spdata.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Spdata.desafio.model.Paciente;
import com.desafio.Spdata.desafio.service.PacienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@ApiOperation(value = "Inserir um novo paciente", response = Paciente.class)
	@PostMapping(value = "/paciente", produces = "application/json")
	public ResponseEntity<?> salvarPaciente(
			@ApiParam(name = "nome", value = "Nome do Paciente", required = true)
			@RequestParam("nome") String nome,
			@ApiParam(name = "cpf", value = "Cpf do Paciente", required = true)
			@RequestParam("cpf") String cpf,
			@ApiParam(name = "dataNascimento", value = "Data nascimento do Paciente", required = true)
			@RequestParam("dataNascimento") String dataNascimento,
			@ApiParam(name = "sexo", allowableValues = "Masculino, Feminino", value = "Sexo do Paciente", required = true)
			@RequestParam("sexo") String sexo,
			@ApiParam(name = "gestante", value = "Paciente em gestação", required = true)
			@RequestParam("gestante") Boolean gestante) {

		try {
			return ResponseEntity.ok(pacienteService.salvarPaciente(nome, cpf, dataNascimento, sexo, gestante));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}
}
