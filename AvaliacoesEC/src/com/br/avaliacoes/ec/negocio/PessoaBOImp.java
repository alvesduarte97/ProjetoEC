package com.br.avaliacoes.ec.negocio;

import java.util.List;

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
		String nome = entity.getNome();
		entity.setSenha(criptografar(entity.getSenha()));
		Pessoa pessoaBusca = repositorio.procurar(entity.getChave());
		Pessoa nomePessoa = repositorio.buscarPessoaNome(entity.getNome());
		
		
		if(entity == null) {
			throw new BancoException("É preciso preencher os campos");
		}else if(nome == null || nome == "" || nome.equals(null) || nome.equals("")) {
			throw new BancoException("Preencha o nome");
		}else if(nomePessoa != null) {
			throw new BancoException("Existe alguem cadastradocom este nome. para facilitar a administração \n "
					+ "                por favor coloque um diferencial em seu nome");
		}else if(pessoaBusca != null) {
			throw new BancoException("Login ja utilizado");
		}else if(entity.getArea() == null) {
			throw new BancoException("Selecione uma area de atuação");
		}else if(entity.getSenha() == null) {
			throw new BancoException("Preencha a senha");
		}else if(entity.getSenha().length() < 6) {
			throw new BancoException("Senha precisa ter no minimo 6 caracteres");
		}else {
			repositorio.inserir(entity);
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
		
		repositorio.atualizar(entity);
	}

	@Override
	public void remover(String chave) throws BancoException {
		if(procurar(chave) == null) {
			throw new BancoException("Login escolhido ja existe");
		}
		
		repositorio.remover(chave);
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

	@Override
	public List<Pessoa> listaPessoa(TipoPessoa tipoPessoa) {
		return repositorio.listaPessoas(tipoPessoa);
	}

	@Override
	public List<Pessoa> listaDePessasNaSerie(String serie) {		
		return repositorio.listaDePessasNaSerie(serie);
	}
	
	
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		PessoaDAOImp rep = new PessoaDAOImp();
		PessoaBOImp repBo = new PessoaBOImp(rep);
		
		List<Pessoa> lista = repBo.listaDePessasNaSerie("9 Ano");
			
		System.out.println(lista.size());
		
		for(int i = 0; i<lista.size(); i++) {
			pessoa = lista.get(i);	
			System.out.println(pessoa.getNome()); 
		}
	
	}

}
