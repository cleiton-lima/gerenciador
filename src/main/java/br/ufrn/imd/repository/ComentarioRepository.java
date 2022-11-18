package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {}


