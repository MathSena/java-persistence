package com.mathsena.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	Optional<Cliente> findByid(String id);

	Cliente findByEmail(String email);

}
