package com.mathsena.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Document
@JsonInclude(Include.NON_NULL)
public class Categoria{
	
	@Id
	private String id;

	private String nome;
	
	@DBRef
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(String id, String nome, List<Produto> produtos) {
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
	}

}
