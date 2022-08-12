package com.mathsena.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.mathsena.cursomc.domain.Cliente;
import com.mathsena.cursomc.dto.CategoriaDTO;
import com.mathsena.cursomc.services.expections.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.repositories.CategoriaRepository;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findByid(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);

	}

	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		UpdateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id){
		find(id);

		try {
			repo.deleteById(id);

		}catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível deletar uma categoria que possui produtos");


		}
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);


	}

	public Categoria fromDTO(CategoriaDTO objDto){
		return new Categoria(objDto.getId(), objDto.getNome());

	}

	private void UpdateData(Categoria newObj, Categoria obj){
		newObj.setNome(obj.getNome());

	}
}
