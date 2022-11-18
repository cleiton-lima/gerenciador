package br.ufrn.imd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.model.Tarefa;
import br.ufrn.imd.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRespository;

    @PostMapping
    public Tarefa create(@RequestBody Tarefa tarefa) {
            return tarefaRespository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> index() {
            return tarefaRespository.findAll();
    }
}
