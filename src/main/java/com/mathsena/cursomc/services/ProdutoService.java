package com.mathsena.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Produto;
import com.mathsena.cursomc.dto.CategoriaDTO;
import com.mathsena.cursomc.repositories.ProdutoRepository;
import com.mathsena.cursomc.services.expections.DataIntegrityException;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(String id) {
		Optional<Produto> obj = repo.findByid(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Produto.class.getName()));
	}

	public Produto insert(Produto obj){
		Optional<Produto> objInDB = repo.findByNome(obj.getNome());
		if(objInDB.isPresent()) {
			obj.setId(objInDB.get().getId());
			return repo.save(obj);
		}
		return repo.save(obj);
	}

	public Optional<Produto> findByName(String nome) {
		Optional<Produto> obj = repo.findByNome(nome);
		return obj;
	}
	
	public Produto update(Produto obj) {
 		Optional<Produto> newObj = findByName(obj.getNome());
		if(newObj.isPresent()) {
			obj.setId(newObj.get().getId());
			updateData(newObj.get(), obj);
			return repo.save(newObj.get());
		}
		return repo.save(obj);
	}

	public void delete(String id){
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível deletar uma categoria que possui produtos");
		}
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}

	public Categoria fromDTO(CategoriaDTO objDto){
		return new Categoria(objDto.getId(), objDto.getNome(), objDto.getProdutos());
	}

	private void updateData(Produto newObj, Produto obj){
		newObj.setNome(obj.getNome());
		newObj.setPreco(obj.getPreco());
	}
	
//	public Produto update(Produto obj) {
//	Produto newObj = find(obj.getId());
//	updateData(newObj, obj);
//	return repo.save(newObj);
//}
	
}
