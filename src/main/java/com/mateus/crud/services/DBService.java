package com.mateus.crud.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.crud.domain.Endereco;
import com.mateus.crud.domain.Pessoa;
import com.mateus.crud.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public void instanciaBaseDeDados() throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Endereco endereco1 = new Endereco( null, "Rua brasil", 21405008, 15, "Campinas", true);
		Endereco endereco2 = new Endereco( null, "Praça diadema", 22456008, 88, "Franca", false);
		
		List<Endereco> e1 = new ArrayList<>();
		e1.add(endereco1);
		e1.add(endereco2);

		Pessoa p1 = new Pessoa( null, "Carlos", sdf.parse("25/03/1990"), e1);
		
		pessoaRepository.saveAll(Arrays.asList(p1));


	}
}
