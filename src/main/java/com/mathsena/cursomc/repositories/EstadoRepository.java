package com.mathsena.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Cidade;
import com.mathsena.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	
	
}
