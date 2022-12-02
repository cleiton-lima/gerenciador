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

import br.ufrn.imd.model.Desenvolvedor;
import br.ufrn.imd.model.Gestor;
import br.ufrn.imd.model.Qa;
import br.ufrn.imd.model.Usuario;
import br.ufrn.imd.repository.UsuarioRepository;

@RestController
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> Get() {
        return usuarioRepository.findAll();
    }
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent())
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/usuarios", method =  RequestMethod.POST)
    public Desenvolvedor create(@RequestBody Desenvolvedor usuario) {
		return usuarioRepository.save((Desenvolvedor) usuario);
	}
	
	@RequestMapping(value = "/usuarios/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Usuario newUsuario)
    {
        Optional<Usuario> oldUsuario = usuarioRepository.findById(id);
        if(oldUsuario.isPresent()){
        	Usuario usuario = oldUsuario.get();
            usuario.setUsername(newUsuario.getUsername());
            usuario.setSenha(newUsuario.getSenha());
            usuario.setTipo(newUsuario.getTipo());
            usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
        	usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
