package com.algaworks.main.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.main.model.Curso;
import com.algaworks.main.service.CursoService;


@RequestMapping
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursoResources {
	
	@Autowired
	  private CursoService service;
	 
	  @PostMapping
	  public List<Curso> salvar(@RequestBody Curso curso) {
		return service.salvar(curso);
		 
	  }
	 
	  @DeleteMapping("/{id}")
	  public List<Curso> deletar(@PathVariable Long id) {
		  return service.deletar(id);
	  }
	  
	  @PutMapping
	  public List<Curso> alterar(@RequestBody Curso curso) {
		  return service.alterar(curso);
	  }
	  
	  @GetMapping
	  public List<Curso> pesquisar(String nome) {
	    return service.pesquisar(nome);
	  }
	
	 
}
