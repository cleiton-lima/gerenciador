package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {}
