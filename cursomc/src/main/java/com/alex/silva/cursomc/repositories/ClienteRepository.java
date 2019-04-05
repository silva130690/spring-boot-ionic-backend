package com.alex.silva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.silva.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	//Categoria findOne(Integer id);

}
