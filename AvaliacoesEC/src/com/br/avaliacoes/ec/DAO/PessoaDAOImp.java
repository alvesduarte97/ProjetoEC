package com.br.avaliacoes.ec.DAO;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public class PessoaDAOImp implements IPessoaDAO {

	@Override
	public void inserir(Pessoa entity) throws BancoException {
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
	public Pessoa procurar(String chave) throws BancoException {

		// Abrindo sessao
		Session session = HibernateUtil.getSessionFactory().openSession();
		Pessoa pessoa = (Pessoa) session.get(Pessoa.class, chave);
		session.close();
		return pessoa;
	}

	@Override
	public void atualizar(Pessoa entity) throws BancoException {

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
		//Importante! o metodo delete so remove objetos,
		//por isso a é preciso procurar para remover.
		session.delete(procurar(chave));

		tx.commit();
		session.flush();
		session.close();
	}

	public List<Pessoa> listaPessoas(TipoPessoa tipoPessoa){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Pessoa.class);
		criteria.add(Restrictions.eq("tipo", tipoPessoa));
		criteria.addOrder(Order.asc("nome"));
		List<Pessoa> lista = criteria.list();
		session.close();
		return lista;
	}
	
	public static void main(String[] args) {
		PessoaDAOImp dao = new PessoaDAOImp();
			List<Pessoa> lista = dao.listaPessoas(TipoPessoa.ORGANIZACAO);
			String finalStr = "";
			for (Pessoa str : lista) {
				if (finalStr.trim().isEmpty()) {
					finalStr = str.getNome();
				} else {
					finalStr = finalStr + "," + str.getNome();
				}
			}
			System.out.println (finalStr);
	}
	
	

}
