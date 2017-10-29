package com.algaworks.main.testes;

import com.algaworks.main.dao.CursoDAO;
import com.algaworks.main.model.Curso;

public class TesteExcluirCurso {

	public static void main(String[] args) throws Exception{
		CursoDAO dao = new CursoDAO();
		Curso curso = dao.listarPorId(Curso.class, 1);
		dao.excluir(curso);
		System.out.println("excluiu?");
		System.out.println("yeeh!");
	}

}
