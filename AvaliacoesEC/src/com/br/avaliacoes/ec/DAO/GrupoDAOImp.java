package com.br.avaliacoes.ec.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.postgresql.core.SqlCommand;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.Regiao;

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

	@Override
	public List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo, String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Grupo.class);
		criteria.add(Restrictions.eq("serie", serie));
		criteria.addOrder(Order.asc("escola"));
		
		List<Grupo> lista = criteria.list();
		List<Grupo> listaFinal = new ArrayList<>();
		for (Grupo grupo : lista) {
			boolean contem = false;
			for (Avaliacoes ava : grupo.getListaAvaliacoes()) {
				if (ava.getDesafio().getNome().equals(desafioAtivo) && ava.getAvaliador().getLogin().equals(login)) {
					contem = true;
					break;
				}
			}
			if (!contem)
				listaFinal.add(grupo);
		}
		return listaFinal;
	}

	public Grupo procurarGrupo(String escola, String serie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Grupo.class);
		criteria.add(Restrictions.eq("escola", escola));
		criteria.add(Restrictions.eq("serie", serie));
		Grupo grupo = (Grupo) criteria.uniqueResult();
		session.close();
		return grupo;

	}

	public static void main(String[] args) {
		GrupoDAOImp dao = new GrupoDAOImp();
//		List<Grupo> lista = dao.listaGruposPorSerie("1ª Serie", "Aguas Profundas");
//		String finalStr = "";
//		for (Grupo str : lista) {
//			if (finalStr.trim().isEmpty()) {
//				finalStr = str.getEscola();
//			} else {
//				finalStr = finalStr + "," + str.getEscola();
//			}
//		}
//		System.out.println (finalStr);
		for(Integer ii = 0; ii <200; ii++) {
			String i = ii.toString();
			Random r = new Random();
			
			Grupo g = new Grupo();
			g.setEscola(i);
			g.setProfessor(i);
			
			//Para adc as regiões aleatoriamente
			switch (r.nextInt(4)) {
			case 0:
				g.setRegiao(Regiao.AGRESTE);
				break;
			case 1:
				g.setRegiao(Regiao.METROPOLITANA);
				break;
			case 2:
				g.setRegiao(Regiao.SERTAO);
				break;
			case 3:
				g.setRegiao(Regiao.ZONADAMATA);
				break;
			default:
				g.setRegiao(Regiao.METROPOLITANA);
				break;
			}
			//Para adc as series aleatoriamente
			switch (r.nextInt(5)) {
			case 0:
				g.setSerie("8 Ano");
				break;
			case 1:
				g.setSerie("9 Ano");
				break;
			case 2:
				g.setSerie("1 Ano");
				break;
			case 3:
				g.setSerie("2 Ano");
				break;
			case 4:
				g.setSerie("3 Ano");
				break;
			default:
				g.setSerie("8 Ano");
				break;
			}
			
			try {
				dao.inserir(g);
			} catch (BancoException e) {
				e.printStackTrace();
			}
			
		}// Fim do for
		System.out.println("Todos os grupos foram adicionados");
	}

}
