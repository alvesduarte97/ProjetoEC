package com.br.avaliacoes.ec.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.StatusDesafio;

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

	@Override
	public List<Desafios> listaDesafios() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Desafios.class);
		List<Desafios> lista = criteria.list();
		session.close();
		
		return lista;
	}

	@Override
	public Desafios desafioAtivo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Desafios.class);
		criteria.add(Restrictions.eq("status", StatusDesafio.ATIVO));
		List<Desafios> desafio = criteria.list();
		Desafios des = new Desafios();
		desafio.add(des);
		session.close();
		return desafio.get(0);
	}

	@Override
	public List<Desafios> listaDesafiosAvaliados() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Desafios.class);
		criteria.add(Restrictions.not(Restrictions.eq("dataInicio", null)));
		List<Desafios> lista = criteria.list();
		session.close();
		return lista;
	}

}
