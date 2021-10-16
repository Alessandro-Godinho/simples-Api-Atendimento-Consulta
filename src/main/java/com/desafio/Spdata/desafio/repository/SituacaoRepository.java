package com.desafio.Spdata.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.Spdata.desafio.model.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
	

}
