package com.mateus.crud.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_endereco;

	private String logradouro;
	private Integer cep;
	private Integer numero;
	private String cidade;
	private Boolean principal;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id_pessoa")
	private Pessoa pessoa_id;

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(Integer id, String logradouro, Integer cep, Integer numero, String cidade, Boolean principal) {
		super();
		this.id_endereco = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.principal = principal;
	}

	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id) {
		this.id_endereco = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Endereco other = (Endereco) obj;
		return id_endereco == other.id_endereco;
	}

}
