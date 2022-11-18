package br.ufrn.imd.controller;

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

import br.ufrn.imd.model.Projeto;
import br.ufrn.imd.repository.ProjetoRepository;

@RestController
public class ProjetoController {
	
	@Autowired
	ProjetoRepository projetoRespository;

	@RequestMapping(value = "/projetos", method = RequestMethod.GET)
    public List<Projeto> Get() {
            return projetoRespository.findAll();
    }
	
	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Projeto> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Projeto> projeto = projetoRespository.findById(id);
        if(projeto.isPresent())
            return new ResponseEntity<Projeto>(projeto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/projetos", method =  RequestMethod.POST)
    public Projeto create(@RequestBody Projeto projeto) {
            return projetoRespository.save(projeto);
    }
	
	@RequestMapping(value = "/projetos/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Projeto> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Projeto newProjeto)
    {
        Optional<Projeto> oldProjeto = projetoRespository.findById(id);
        if(oldProjeto.isPresent()){
        	Projeto projeto = oldProjeto.get();
            projeto.setNome(newProjeto.getNome());
            projetoRespository.save(projeto);
            return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/projetos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Projeto> projeto = projetoRespository.findById(id);
        if(projeto.isPresent()){
        	projetoRespository.delete(projeto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
