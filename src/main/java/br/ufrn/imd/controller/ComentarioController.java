package br.ufrn.imd.controller;

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

import br.ufrn.imd.model.Comentario;
import br.ufrn.imd.repository.ComentarioRepository;

@RestController
@CrossOrigin
public class ComentarioController {
	
	@Autowired
	ComentarioRepository comentarioRepository;

	@RequestMapping(value = "/comentarios", method = RequestMethod.GET)
    public List<Comentario> Get() {
            return comentarioRepository.findAll();
    }
	
	@RequestMapping(value = "/comentarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Comentario> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Comentario> comentario = comentarioRepository.findById(id);
        if(comentario.isPresent())
            return new ResponseEntity<Comentario>(comentario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/comentarios", method =  RequestMethod.POST)
    public Comentario create(@RequestBody Comentario comentario) {
            return comentarioRepository.save(comentario);
    }
	
	@RequestMapping(value = "/comentarios/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Comentario> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Comentario newComentario)
    {
        Optional<Comentario> oldComentario = comentarioRepository.findById(id);
        if(oldComentario.isPresent()){
        	Comentario comentario = oldComentario.get();
            comentario.setDescricao(newComentario.getDescricao());
            comentarioRepository.save(comentario);
            return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/comentarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Comentario> comentario = comentarioRepository.findById(id);
        if(comentario.isPresent()){
        	comentarioRepository.delete(comentario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}