package com.alex.silva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.silva.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

	//Categoria findOne(Integer id);

}
