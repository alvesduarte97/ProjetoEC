package com.br.avaliacoes.ec.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;

public class AvaliacoesDAOImp implements IAvaliacoesDAO {

	@Override
	public void inserir(Avaliacoes entity) throws BancoException {
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
	public Avaliacoes procurar(Integer chave) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Avaliacoes avaliacao = (Avaliacoes) session.get(Avaliacoes.class, chave);
		session.close();
		return avaliacao;
	}

	@Override
	public void atualizar(Avaliacoes entity) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		session.update(entity);

		tx.commit();
		session.flush();
		session.close();
	}

	@Override
	public void remover(Integer chave) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		session.delete(procurar(chave));

		tx.commit();
		session.flush();
		session.close();

	}

}
