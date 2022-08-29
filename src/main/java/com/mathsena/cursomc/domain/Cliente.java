package com.mathsena.cursomc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mathsena.cursomc.domain.enums.TipoCliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Cliente {

	@Id
	private String id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	
//	@DBRef
	private List<Endereco> enderecos = new ArrayList<>();
	
	private Set<String> telefones = new HashSet<>();
	
//	@DBRef
	private List<Pedido> pedidos = new ArrayList<>();


	public Cliente(String id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo==null) ? null : tipo.getCod();
	}


}
