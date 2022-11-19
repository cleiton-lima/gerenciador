package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
