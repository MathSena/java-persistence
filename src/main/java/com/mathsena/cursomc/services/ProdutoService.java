package com.mathsena.cursomc.services;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Produto;
import com.mathsena.cursomc.repositories.CategoriaRepository;
import com.mathsena.cursomc.repositories.ProdutoRepository;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findByid(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);

	}

}
