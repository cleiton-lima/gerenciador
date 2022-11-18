package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
