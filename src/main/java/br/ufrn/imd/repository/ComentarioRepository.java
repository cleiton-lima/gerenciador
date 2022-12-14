package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {}
