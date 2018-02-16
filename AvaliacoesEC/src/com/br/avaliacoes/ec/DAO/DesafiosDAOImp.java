package com.br.avaliacoes.ec.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Desafios;

public class DesafiosDAOImp implements IDesafiosDAO {

	@Override
	public void inserir(Desafios entity) throws BancoException {
		// Abrindo sessao
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Abrindo transaction para poder salvar as alteracoes no banco
		Transaction tx = session.beginTransaction();
		// Salvando pessoa no banco
		session.save(entity);

		// Usando commit para confirmar as ateracoes no banco
		tx.commit();
		session.flush();
		session.close();

	}

	@Override
	public Desafios procurar(String chave) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Desafios desafio = (Desafios) session.get(Desafios.class, chave);
		session.close();
		return desafio;
	}

	@Override
	public void atualizar(Desafios entity) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		session.update(entity);

		tx.commit();
		session.flush();
		session.close();

	}

	@Override
	public void remover(String chave) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		session.delete(procurar(chave));

		tx.commit();
		session.flush();
		session.close();
	}

}
