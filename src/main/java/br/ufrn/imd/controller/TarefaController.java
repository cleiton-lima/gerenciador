package br.ufrn.imd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.model.Comentario;
import br.ufrn.imd.model.Projeto;
import br.ufrn.imd.model.Tarefa;
import br.ufrn.imd.repository.ComentarioRepository;
import br.ufrn.imd.repository.TarefaRepository;

@RestController
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	@Autowired
	ComentarioRepository comentarioRepository;

	@RequestMapping(value = "/tarefas", method = RequestMethod.GET)
    public List<Tarefa> Get() {
            return tarefaRepository.findAll();
    }
	
	@RequestMapping(value = "/tarefas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tarefa> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if(tarefa.isPresent())
            return new ResponseEntity<Tarefa>(tarefa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/tarefas", method =  RequestMethod.POST)
    public Tarefa create(@RequestBody Tarefa tarefa) {
            return tarefaRepository.save(tarefa);
    }
	
	@RequestMapping(value = "/tarefas/{id}/comentarios", method = RequestMethod.GET)
    public List<Comentario> GetComentariosByTarefa(@PathVariable(value = "id") long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if(tarefa.isPresent()){
        	return tarefa.get().getComentarios();
        }
        else
        	return new ArrayList<Comentario>();
    }
	
	@PostMapping("/tarefas/{id}/comentarios")
    public ResponseEntity<Comentario> createComentariosOnTarefa(@PathVariable(value = "id") long id, @RequestBody Comentario newComentario) {        
		Comentario comentario = tarefaRepository.findById(id).map(tarefa -> {
        	newComentario.setTarefa(tarefa);
  	      return comentarioRepository.save(newComentario);
  	    }).orElseThrow();

  	    return new ResponseEntity<>(newComentario, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/tarefas/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Tarefa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Tarefa newTarefa)
    {
        Optional<Tarefa> oldTarefa = tarefaRepository.findById(id);
        if(oldTarefa.isPresent()){
        	Tarefa tarefa = oldTarefa.get();
            tarefa.setTitulo(newTarefa.getTitulo());
            tarefa.setDescricao(newTarefa.getDescricao());
            tarefa.setData(newTarefa.getData());
            tarefa.setResponsavel(newTarefa.getResponsavel());
            tarefaRepository.save(tarefa);
            return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/tarefas/{id}/status", method =  RequestMethod.PUT)
    public ResponseEntity<Tarefa> PutStatus(@PathVariable(value = "id") long id, @Valid @RequestBody Tarefa newTarefa)
    {
        Optional<Tarefa> oldTarefa = tarefaRepository.findById(id);
        if(oldTarefa.isPresent()){
        	Tarefa tarefa = oldTarefa.get();
            tarefa.setStatus(newTarefa.getStatus());
            tarefaRepository.save(tarefa);
            return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/tarefas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if(tarefa.isPresent()){
        	tarefaRepository.delete(tarefa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}