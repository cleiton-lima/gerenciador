package br.ufrn.imd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.model.Projeto;
import br.ufrn.imd.repository.ProjetoRepository;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	ProjetoRepository projetoRespository;

    @PostMapping
    public Projeto create(@RequestBody Projeto projeto) {
            return projetoRespository.save(projeto);
    }

    @GetMapping
    public List<Projeto> index() {
            return projetoRespository.findAll();
    }
}
