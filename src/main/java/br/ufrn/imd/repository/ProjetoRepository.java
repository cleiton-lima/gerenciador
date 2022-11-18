package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {}
