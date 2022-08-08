package com.mathsena.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.repositories.CategoriaRepository;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findByid(id);

		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Categoria.class.getName()));

		
	}
	

}
