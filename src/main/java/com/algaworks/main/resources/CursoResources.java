package com.algaworks.main.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.main.dao.CursoDAO;
import com.algaworks.main.model.Curso;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursoResources {
	
	CursoDAO dao;
	
	@Autowired
	public CursoResources(CursoDAO dao) {
		this.dao = dao;
	}
	
	//CursoDAO dao = new CursoDAO();
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<List<Curso>> adicionar(@RequestBody Curso curso) {
		dao.salvar(curso);
		
		return new ResponseEntity<List<Curso>>(new ArrayList<Curso>(dao.listar(Curso.class)), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<?> alterar(@RequestBody Curso curso) throws Exception {
		Curso curso1 = dao.listarPorId(Curso.class, curso.getId());
		curso1.setNome(curso.getNome());
		curso1.setDuracao(curso.getDuracao());
		dao.alterar(curso1);
		
	  return new ResponseEntity<List<Curso>>(new ArrayList<Curso>(dao.listar(Curso.class)), HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	  public ResponseEntity<List<Curso>> listar() {
	    return new ResponseEntity<List<Curso>>(new ArrayList<Curso>(dao.listar(Curso.class)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") int id) throws Exception {
		Curso curso = dao.listarPorId(Curso.class, id);
		dao.excluir(curso);
	 
	  if (curso == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<List<Curso>>(new ArrayList<Curso>(dao.listar(Curso.class)), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/buscarCursos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> buscar(@PathVariable("id") Integer id) throws Exception {
	  Curso curso = dao.listarPorId(Curso.class, id);
	 
	  if (curso == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
}
