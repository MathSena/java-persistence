package com.mathsena.cursomc.repositories;

import java.util.Optional;

import com.mathsena.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    Optional<Cidade> findByid(Integer id);

}
