package com.mateus.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.crud.domain.Pessoa;
import com.mateus.crud.repositories.PessoaRepository;
import com.mateus.crud.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa findById(Integer id_pessoa) {
		Optional<Pessoa> obj = repository.findById(id_pessoa);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id_pessoa + ", Tipo: " + Pessoa.class.getName()));
	}

	public List<Pessoa> findAll() {
		List<Pessoa> list = repository.findAll();
		return list;
	}

	public Pessoa create(Pessoa obj) {
		return repository.save(obj);
	}

	public void delete(Integer id_pessoa) {
		repository.deleteById(id_pessoa);
	}

	public Pessoa update(Integer id_pessoa, Pessoa obj) {
		Pessoa newObj = findById(id_pessoa);
		newObj.setNome(obj.getNome());
		newObj.setDataNascimento(obj.getDataNascimento());
		return repository.save(newObj);
	}

}



