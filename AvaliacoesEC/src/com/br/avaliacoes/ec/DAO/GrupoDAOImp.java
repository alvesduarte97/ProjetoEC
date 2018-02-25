package com.br.avaliacoes.ec.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;

public class GrupoDAOImp implements IGrupoDAO {

	@Override
	public void inserir(Grupo entity) throws BancoException {
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
	public Grupo procurar(Integer chave) throws BancoException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Grupo grupo = (Grupo) session.get(Grupo.class, chave);
		session.close();
		return grupo;
	}

	@Override
	public void atualizar(Grupo entity) throws BancoException {
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

	@Override
	public List<Grupo> listaGrupos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Grupo.class);
		List<Grupo> lista = criteria.list();
		session.close();
		return lista;
	}
	 public static void main(String[] args) {
		GrupoDAOImp dao = new GrupoDAOImp();
		List<Grupo> lista = dao.listaGrupos();
		String finalStr = "";
		for (Grupo str : lista) {
			if (finalStr.trim().isEmpty()) {
				finalStr = str.getEscola();
			} else {
				finalStr = finalStr + "," + str.getEscola();
			}
		}
		System.out.println (finalStr);
	}

	@Override
	public List<Grupo> listaGruposPorSerie(String serie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Grupo.class);
		criteria.add(Restrictions.eq("serie", serie));
		criteria.add(Restrictions.isEmpty("listaAvaliacoes"));
		criteria.addOrder(Order.asc("serie"));
		List<Grupo> lista = criteria.list();
		return lista;
	}

}
