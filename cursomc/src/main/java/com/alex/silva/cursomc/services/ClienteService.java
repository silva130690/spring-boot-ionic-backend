package com.alex.silva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.silva.cursomc.domain.Cliente;
import com.alex.silva.cursomc.repositories.ClienteRepository;
import com.alex.silva.cursomc.services.Excepitions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Optional<Cliente> buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
           throw new  ObjectNotFoundException("Objeto Não encontrado id: "+id +" tipo, :  "+ Cliente.class.getCanonicalName());
		}
			return obj;
		

	}

}
