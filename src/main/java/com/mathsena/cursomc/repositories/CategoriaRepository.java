package com.mathsena.cursomc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
	
	Optional<Categoria> findByid(String id);
	
	@Query(value="{}", fields="{produtos : 0}")
	public List<Categoria> findCategoria();
	
}
