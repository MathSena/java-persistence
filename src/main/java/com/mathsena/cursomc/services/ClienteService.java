package com.mathsena.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.mathsena.cursomc.dto.ClienteDTO;
import com.mathsena.cursomc.services.expections.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mathsena.cursomc.domain.Cliente;
import com.mathsena.cursomc.repositories.ClienteRepository;
import com.mathsena.cursomc.services.expections.ObjectNotFoundException;

import javax.validation.Valid;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findByid(id);

		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id" + id + " , Tipo: " + Cliente.class.getName()));

		
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		UpdateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id){
		find(id);

		try {
			repo.deleteById(id);

		}catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível deletar uma Cliente que possui produtos");


		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);


	}

	public Cliente fromDTO(@Valid ClienteDTO objDto){
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);

	}

	private void UpdateData(Cliente newObj, Cliente obj){
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	

}
