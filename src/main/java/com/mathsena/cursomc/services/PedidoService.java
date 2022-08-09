package com.mathsena.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathsena.cursomc.domain.Pedido;
import com.mathsena.cursomc.repositories.PedidoRepository;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findByid(id);

		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Pedido.class.getName()));

		
	}
	

}
