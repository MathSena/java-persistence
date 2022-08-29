package com.mathsena.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
	
	Optional<Endereco> findByid(Integer id);

}
