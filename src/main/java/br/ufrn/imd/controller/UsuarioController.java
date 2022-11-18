package br.ufrn.imd.controller;

import java.util.List;
import br.ufrn.imd.model.Usuario;
import br.ufrn.imd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRespository;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
            return usuarioRespository.save(usuario);
    }

    @GetMapping
    public List<Usuario> index() {
            return usuarioRespository.findAll();
    }
}
