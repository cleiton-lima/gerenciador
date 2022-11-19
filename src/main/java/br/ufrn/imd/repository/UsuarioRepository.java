package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
