package com.mateus.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mateus.crud.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	@Query("SELECT ps.enderecos FROM Pessoa ps WHERE ps.id_pessoa = :id")
	List<Endereco> findEnderecoById(Integer id);
	
	@Query("SELECT ed FROM Endereco ed, Pessoa ps WHERE ps.id_pessoa = :id AND ed.principal = true" )
	List<Endereco> findEnderecoByIdPrincipal(Integer id);

}
