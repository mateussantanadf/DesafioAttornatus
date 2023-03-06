package com.mateus.crud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.crud.domain.Endereco;
import com.mateus.crud.domain.Pessoa;
import com.mateus.crud.services.EnderecoService;
import com.mateus.crud.services.PessoaService;


@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Endereco>> findEnderecoById(@PathVariable Integer id){
		List<Endereco> list = service.findEnderecoById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Endereco> createEndereco(@PathVariable Integer id, @RequestBody Endereco obj){
		List<Endereco> list = service.findEnderecoById(id);
		obj = service.create(obj);
		list.add(obj);
		Pessoa newObj = pessoaService.findById(id);
		newObj.setEnderecos(list);
		pessoaService.update(id, newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_endereco()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping(value = "/principal/{id}")
	public ResponseEntity<List<Endereco>> findEnderecoByIdPrincipal(@PathVariable Integer id){
		List<Endereco> list = service.findEnderecoByIdPrincipal(id);
		return ResponseEntity.ok().body(list);
	}
	
}
