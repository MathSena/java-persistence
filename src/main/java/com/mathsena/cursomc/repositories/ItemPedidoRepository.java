package com.mathsena.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	Optional<ItemPedido> findByid(Integer id);
	

}
