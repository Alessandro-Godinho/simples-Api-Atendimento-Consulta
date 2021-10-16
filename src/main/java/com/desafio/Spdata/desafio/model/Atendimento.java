package com.desafio.Spdata.desafio.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "ATENDIMENTO")
public class Atendimento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATAHORAATEND")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataAtendimento;
	@Column(name = "DIAGNOSTICO")
	private String dianostico;
	@Column(name = "DATAHORAENCER")
	private LocalDateTime dataHoraEncerramento;
	@Column(name = "DURACAO")
	private LocalDateTime duracao;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "SITUACAO_ID", referencedColumnName = "ID")
	private Situacao situacao; 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PACIENTE_ID", referencedColumnName = "ID")
	private Paciente paciente;
}
