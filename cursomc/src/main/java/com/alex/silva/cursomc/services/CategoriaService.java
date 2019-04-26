package com.alex.silva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.silva.cursomc.domain.Categoria;
import com.alex.silva.cursomc.repositories.CategoriaRepository;
import com.alex.silva.cursomc.services.Excepitions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
           throw new  ObjectNotFoundException("Objeto Não encontrado id: "+id +" tipo, :  "+ Categoria.class.getCanonicalName());
		}
			return obj;
		

	}

}
