package br.ufrn.imd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.model.Comentario;
import br.ufrn.imd.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
	
	@Autowired
	ComentarioRepository comentarioRespository;
	
	@PostMapping
    public Comentario create(@RequestBody Comentario comentario) {
            return comentarioRespository.save(comentario);
    }

    @GetMapping
    public List<Comentario> index() {
            return comentarioRespository.findAll();
    }
}
