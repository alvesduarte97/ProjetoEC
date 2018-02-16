package com.br.avaliacoes.ec.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Pessoa;

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

	public static void main(String[] args) {
		PessoaDAOImp busca = new PessoaDAOImp();
		Pessoa pessoa = new Pessoa();
//		pessoa.setArea(AreaAtuacao.CORDENACAO);
//		pessoa.setLogin("ADM");
//		pessoa.setNome("Admnistrador");
//		pessoa.setSenha("adm123");
//		pessoa.setTipo(TipoPessoa.ORGANIZACAO);

		try {
			pessoa = busca.procurar("ADM");
			//busca.remover("ADM");
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pessoa.getArea());
		System.out.println(pessoa.getNome());
	}

}
