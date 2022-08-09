package com.mathsena.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Pagamento;
import com.mathsena.cursomc.domain.Pedido;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

	Optional<Pagamento> findByid(Integer id);
	

}
