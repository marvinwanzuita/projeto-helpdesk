package com.mrvw.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrvw.bookstore.domain.Pessoa;
import com.mrvw.bookstore.domain.Tecnico;
import com.mrvw.bookstore.domain.dtos.TecnicoDTO;
import com.mrvw.bookstore.repositories.PessoaRepository;
import com.mrvw.bookstore.repositories.TecnicoRepository;
import com.mrvw.bookstore.services.exceptions.DataIntegrityViolationException;
import com.mrvw.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDto) {
		objDto.setId(null);
		validaPorCpfEEmail(objDto);
		Tecnico newObj = new Tecnico(objDto);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado!");
		}
		
		obj = pessoaRepository.findByEmail(objDto.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado!");
		}
		
		
	}
	
	

}
