package com.mrvw.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrvw.bookstore.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
