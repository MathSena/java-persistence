package com.mathsena.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathsena.cursomc.domain.Cliente;
import com.mathsena.cursomc.repositories.ClienteRepository;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findByid(id);

		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Cliente.class.getName()));

		
	}
	

}
