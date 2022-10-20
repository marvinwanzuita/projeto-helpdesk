package com.mrvw.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrvw.bookstore.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
