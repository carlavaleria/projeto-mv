package com.algaworks.main.criacao.hibernate;

import com.algaworks.main.sessaoHibernate.HibernateUtil;

public class TesteCriacao {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
