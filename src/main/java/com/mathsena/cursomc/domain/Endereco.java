package com.mathsena.cursomc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	private String id;
	private String longradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	private Cidade cidade;


}
