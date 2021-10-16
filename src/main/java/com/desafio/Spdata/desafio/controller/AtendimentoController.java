package com.desafio.Spdata.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Spdata.desafio.dto.AtendimentoDto;
import com.desafio.Spdata.desafio.dto.EncerramentoDto;
import com.desafio.Spdata.desafio.service.AtendimentoService;
import com.desafio.Spdata.desafio.service.PacienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/")
public class AtendimentoController {
	
	@Autowired
	PacienteService pacienteService;
	@Autowired
	AtendimentoService atendimentoService;
	
	@ApiOperation(value = "Inserir um novo atendimento", response = AtendimentoDto.class)
	@PostMapping(value = "/atendimento", produces = "application/json")
	public ResponseEntity<?> salvarAtendimento(
			@ApiParam(name = "salvarAtendimento", value = "Objeto do tipo Atendimento", required = true) 
			@RequestBody AtendimentoDto atendimento) {

		try {
			return ResponseEntity.ok(atendimentoService.salvarAtendimento(atendimento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}


	}

	@ApiOperation(value = "Encerrar um atendimento", response = EncerramentoDto.class)
	@PutMapping(value = "/encerramento", produces = "application/json")
	public ResponseEntity<?> salvarEncerramento(
			@ApiParam(name = "salvarEncerramento", value = "Objeto do tipo Atendimento", required = true) 
			@RequestBody EncerramentoDto encerramento) {

		try {
			return ResponseEntity.ok(atendimentoService.encerrarAtendimento(encerramento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
