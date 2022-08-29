package com.mathsena.cursomc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Produto {
	
	@Id
	private String id;
	private String nome;
	private double preco;

}
