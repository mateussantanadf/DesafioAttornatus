package com.mateus.crud.resource;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.mateus.crud.domain.Endereco;
import com.mateus.crud.domain.Pessoa;
import com.mateus.crud.resources.PessoaResource;
import com.mateus.crud.services.EnderecoService;
import com.mateus.crud.services.PessoaService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class PessoaResourceTest {

	@Autowired
	private PessoaResource pessoaResource;

	@MockBean
	private PessoaService pessoaService;

	@MockBean
	private EnderecoService enderecoService;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.pessoaResource);
	}

	@Test
	public void deveRetornarSucesso_QuandoBuscarPessoa() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Endereco endereco1 = new Endereco(null, "Praça diadema", 22456008, 88, "Franca", false);
		List<Endereco> e1 = new ArrayList<>();
		e1.add(endereco1);

		when(this.pessoaService.findById(1)).thenReturn(new Pessoa(1, "Eduardo", sdf.parse("11/10/2001"), e1));

		given().accept(ContentType.JSON).when().get("/pessoas/{id_pessoa}", 1).then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarPessoa() {
		
		when(this.pessoaService.findById(5))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/pessoas/{id_pessoa}", 5)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
}
