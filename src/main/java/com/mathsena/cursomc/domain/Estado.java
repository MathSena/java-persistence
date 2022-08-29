package com.mathsena.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Estado   {
	
	@Id
	private Integer id;
	private String nome;
	
	private List<Cidade> cidades = new ArrayList<>();
	

	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

}
