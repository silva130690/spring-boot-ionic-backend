package com.alex.silva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.silva.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {


}
