package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
