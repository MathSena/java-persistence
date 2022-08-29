package com.mathsena.cursomc.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Pedido {
	@Id
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;

	private Pagamento pagamento;

	private Cliente cliente;

	private Endereco enderecoDeEntrega;

	private Set<ItemPedido> itens = new HashSet<>();


	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;

		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}


}
