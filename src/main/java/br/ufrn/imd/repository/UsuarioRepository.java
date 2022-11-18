package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.model.Usuario;

//usa o JpaRepository para fazer as operações de CRUD

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
