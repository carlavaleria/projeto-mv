package com.algaworks.main.dao;

import org.hibernate.Transaction;

import com.algaworks.main.model.Curso;

public class CursoDAO extends GenericDAO<Curso, Long>{
	
	public Curso listarPorId(Class<Curso> classe, String pk) throws Exception{
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Curso curso = (Curso) session.load(classe, pk);
			session.flush();
			transaction.commit();
			return  curso;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
