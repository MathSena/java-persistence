package com.mathsena.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
	
	Optional<Produto> findByid(String id);
	
	Optional<Produto> findByNome(String nome);

}
