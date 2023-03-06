package com.mateus.crud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.crud.domain.Pessoa;
import com.mateus.crud.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@GetMapping(value = "/{id_pessoa}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id_pessoa){
		Pessoa obj = service.findById(id_pessoa);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listAll() {
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_pessoa}").buildAndExpand(obj.getId_pessoa()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id_pessoa}")
	public ResponseEntity<Void> delete(@PathVariable Integer id_pessoa){
		service.delete(id_pessoa);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id_pessoa}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id_pessoa, @RequestBody Pessoa obj) {
		Pessoa newObj = service.update(id_pessoa, obj);
		return ResponseEntity.ok().body(newObj);
	}
		
}




