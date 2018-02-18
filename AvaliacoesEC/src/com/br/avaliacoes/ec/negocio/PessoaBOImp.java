package com.br.avaliacoes.ec.negocio;

import com.br.avaliacoes.ec.DAO.IPessoaDAO;
import com.br.avaliacoes.ec.DAO.PessoaDAOImp;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public class PessoaBOImp implements IPessoaBO {

	private IPessoaDAO repositorio;
	
	public PessoaBOImp(IPessoaDAO repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public void inserir(Pessoa entity) throws BancoException {
		if(entity == null) {
			throw new BancoException("É preciso preencher os campos");
		}

		entity.setSenha(criptografar(entity.getSenha()));
		
		Pessoa pessoaBusca = procurar(entity.getLogin());
		if(pessoaBusca == null) {
			repositorio.inserir(entity);
		}else {
			throw new BancoException("Login ja utilizado");
		}
	       
	}

	@Override
	public Pessoa procurar(String chave) throws BancoException {
		Pessoa pessoaBusca = repositorio.procurar(chave);
		if(pessoaBusca == null) {
			throw new BancoException("Login não cadastrado");
		}else {
		return pessoaBusca;
		}
	}

	@Override
	public void atualizar(Pessoa entity) throws BancoException {
		if(entity == null) {
			throw new BancoException("Preencha ao menos um campo para ser atualizado");
		}
		
		if(procurar(entity.getLogin()) != null) {
			throw new BancoException("Login escolhido ja existe");
		}
		
		repositorio.atualizar(entity);
	}

	@Override
	public void remover(String chave) throws BancoException {
		if(procurar(chave) == null) {
			throw new BancoException("Login escolhido ja existe");
		}
		
		repositorio.remover(chave);
	}
	
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setLogin("aad");
		pessoa.setNome("Anderson");
		pessoa.setSenha("123NgmDescobre");
		pessoa.setTipo(TipoPessoa.ORGANIZACAO);
		
		PessoaDAOImp rep = new PessoaDAOImp();
		PessoaBOImp repBo = new PessoaBOImp(rep);
		
		try {
			repBo.inserir(pessoa);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static String criptografar(String senha) {
		String texto = senha;
		String alfabeto = " <ab@#$%&*(cdefÍÚÃÕ1234ghijklmnopqrstuvwx]}§[{ª!)yzçéáíúóãõABCDEFGHIJKLMNOPQRSTUVWXYZÇÁÉÓ567890.;:?,º_+-=\\/|\'\">";   
	       char[] t = texto.toCharArray();  
	        String palavra="";  
	        
	        for (int i = 0; i < t.length; i++) {  
	        	int chave = t.length;
	            int posicao = alfabeto.indexOf(t[i]) + chave;  
	  
	            if (alfabeto.length() <= posicao) {  
	  
	                posicao = posicao - alfabeto.length();  
	  
	            }
	  
	            palavra = palavra + alfabeto.charAt(posicao);  
	        }
	        return palavra;
	}

}
