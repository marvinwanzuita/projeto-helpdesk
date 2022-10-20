package com.mrvw.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrvw.bookstore.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
