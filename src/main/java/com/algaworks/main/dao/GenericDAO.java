package com.algaworks.main.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.main.model.Curso;

public interface GenericDAO extends JpaRepository<Curso, Long>{
	
  //Pesquisar apenas pelo nome 
	
  	@Query("from Curso where nome like concat(?1, '%')")
  	List<Curso> findByNome(String nome);
  	
}
