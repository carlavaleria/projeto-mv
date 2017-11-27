package com.algaworks.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.main.dao.GenericDAO;
import com.algaworks.main.model.Curso;

@Service
public class CursoService {
	
	@Autowired
	  private GenericDAO dao;
	
	public List<Curso> salvar(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	public List<Curso> deletar(Long id) {
		dao.delete(id);
		return dao.findAll();
	}

	public List<Curso> alterar(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}
	
	
	public List<Curso> pesquisar(String nome){
    	if (nome != null) {
    		return dao.findByNome(nome);
    	}
    	return dao.findAll();
  }
	
}
