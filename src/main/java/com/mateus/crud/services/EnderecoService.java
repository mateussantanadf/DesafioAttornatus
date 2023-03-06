package com.mateus.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.crud.domain.Endereco;
import com.mateus.crud.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findEnderecoById(Integer id) {
		List<Endereco> list = repository.findEnderecoById(id);
		return list;
	}
	
	public Endereco create(Endereco obj) {
		return repository.save(obj);
	}

	public List<Endereco> findEnderecoByIdPrincipal(Integer id) {
		List<Endereco> list = repository.findEnderecoByIdPrincipal(id);
		return list;
	}

	
}
