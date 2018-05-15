package com.br.avaliacoes.ec.extras;

import java.util.Random;

import com.br.avaliacoes.ec.DAO.GrupoDAOImp;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Regiao;

public class testando {

	public static void main(String[] args) {

		GrupoDAOImp dao = new GrupoDAOImp();
		
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
