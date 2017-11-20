package com.algaworks.main.testes;

import com.algaworks.main.dao.CursoDAO;
import com.algaworks.main.model.Curso;

public class TesteAdicionarCurso {

	public static void main(String[] args) {
		CursoDAO dao = new CursoDAO();
		Curso curso = new Curso();
		curso.setNome("estágio");
		curso.setDuracao("300");
		dao.salvar(curso);
		System.out.println("salvou?");
		System.out.println("yeeh!");
	}

}
