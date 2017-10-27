package com.algaworks.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.algaworks.main.dao.CursoDAO;


public class CursoController {
	CursoDAO dao;
	
	public CursoController(CursoDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("inicio")
	public String inicio() {
		return "index";
	}
	
	public String adicionarCurso() {
		return "add";
	}
	
	
	public String listarCurso() {
		return "listar";
	}
	
	public String excluirCurso() {
		return "excluir";
	}
	
	public String alterarCurso() {
		return "alterar";
	}
	
	
}
