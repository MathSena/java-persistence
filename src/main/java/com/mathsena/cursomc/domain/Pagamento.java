package com.mathsena.cursomc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mathsena.cursomc.domain.enums.EstadoPagamento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Pagamento  {
	
	@Id
	private Integer id;
	private Integer estado;
	
	private Pedido pedido;


	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado==null ) ? null: estado.getCod();
		this.pedido = pedido;
	}

}
