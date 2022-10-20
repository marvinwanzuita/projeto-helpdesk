package com.mrvw.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrvw.bookstore.domain.Chamado;
import com.mrvw.bookstore.domain.Cliente;
import com.mrvw.bookstore.domain.Tecnico;
import com.mrvw.bookstore.enums.Perfil;
import com.mrvw.bookstore.enums.Prioridade;
import com.mrvw.bookstore.enums.Status;
import com.mrvw.bookstore.repositories.ChamadoRepository;
import com.mrvw.bookstore.repositories.ClienteRepository;
import com.mrvw.bookstore.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Marvin", "63653230268", "marvin@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Trovalds", "80527954780", "trovaldis@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
