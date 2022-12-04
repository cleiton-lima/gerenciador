package br.ufrn.imd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.model.Projeto;
import br.ufrn.imd.model.Tarefa;
import br.ufrn.imd.repository.ProjetoRepository;
import br.ufrn.imd.repository.TarefaRepository;
import br.ufrn.imd.service.TarefaService;
import br.ufrn.imd.service.ProjetoService;

@RestController
@CrossOrigin
public class ProjetoController {
	
	@Autowired
	ProjetoRepository projetoRepository;
	@Autowired
	TarefaRepository tarefaRepository;

	@RequestMapping(value = "/projetos", method = RequestMethod.GET)
    public List<Projeto> Get() {
            return projetoRepository.findAll();
    }
	
	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Projeto> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent())
            return new ResponseEntity<Projeto>(projeto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/projetos", method =  RequestMethod.POST)
    public Projeto create(@RequestBody Projeto projeto) {
            return projetoRepository.save(projeto);
    }
	
	@RequestMapping(value = "/projetos/{id}/tarefas", method = RequestMethod.GET)
    public List<Tarefa> GetTarefasByProject(@PathVariable(value = "id") long id) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
        	return projeto.get().getTarefas();
        }
        else
            return new ArrayList<Tarefa>();
    }
	
	@PostMapping("/projetos/{id}/tarefas")
    public ResponseEntity<Tarefa> createTarefasOnProject(@PathVariable(value = "id") long id, @RequestBody Tarefa newTarefa) {        
        Tarefa tarefa = projetoRepository.findById(id).map(projeto -> {
        	newTarefa.setProjeto(projeto);
  	      return tarefaRepository.save(newTarefa);
  	    }).orElseThrow();

  	    return new ResponseEntity<>(newTarefa, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/projetos/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Projeto> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Projeto newProjeto)
    {
        Optional<Projeto> oldProjeto = projetoRepository.findById(id);
        if(oldProjeto.isPresent()){
        	Projeto projeto = oldProjeto.get();
            projeto.setNome(newProjeto.getNome());
            projeto.setDescricao(newProjeto.getDescricao());
            projetoRepository.save(projeto);
            return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/projetos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
        	projetoRepository.delete(projeto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
