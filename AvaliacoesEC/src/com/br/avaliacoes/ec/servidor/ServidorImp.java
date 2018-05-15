package com.br.avaliacoes.ec.servidor;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.br.avaliacoes.ec.DAO.AvaliacoesDAOImp;
import com.br.avaliacoes.ec.DAO.DesafiosDAOImp;
import com.br.avaliacoes.ec.DAO.GrupoDAOImp;
import com.br.avaliacoes.ec.DAO.HibernateUtil;
import com.br.avaliacoes.ec.DAO.IAvaliacoesDAO;
import com.br.avaliacoes.ec.DAO.IDesafiosDAO;
import com.br.avaliacoes.ec.DAO.IGrupoDAO;
import com.br.avaliacoes.ec.DAO.IPessoaDAO;
import com.br.avaliacoes.ec.DAO.PessoaDAOImp;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;
import com.br.avaliacoes.ec.negocio.AvaliacoesBOImp;
import com.br.avaliacoes.ec.negocio.DesafioBOImp;
import com.br.avaliacoes.ec.negocio.GrupoBOImp;
import com.br.avaliacoes.ec.negocio.IAvaliacoesBO;
import com.br.avaliacoes.ec.negocio.IDesafioBO;
import com.br.avaliacoes.ec.negocio.IGrupoBO;
import com.br.avaliacoes.ec.negocio.IPessoaBO;
import com.br.avaliacoes.ec.negocio.PessoaBOImp;


public class ServidorImp extends UnicastRemoteObject implements IServidor{
	
	private JFrame frame;
	private JTextArea textArea;
	
	private String diretorioVideo;
	
	//Propriedades para comunicação 
	private IPessoaBO negocioPessoa;
	private IDesafioBO negocioDesafio;
	private IGrupoBO negocioGrupo;
	private IAvaliacoesBO negocioAvaliacao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorImp instanciaServidor = new ServidorImp();

						File policyFile = new File("security/security.policy");

						InputStream fis = ServidorImp.class.getClassLoader()
								.getResourceAsStream("serverconfig.properties");
						Properties prop = new Properties();
						prop.load(fis);
						
						String ipServer = prop.getProperty("server_ip");
						System.out.println(ipServer);
						String porta = prop.getProperty("server_port");
						
						instanciaServidor.setDiretorioVideo(prop.getProperty("diretorio_video"));
						
						System.setProperty("java.security.policy", policyFile.getCanonicalPath());
						
						System.setSecurityManager(new SecurityManager());
						System.setProperty("java.rmi.server.hostname", ipServer);
						
						LocateRegistry.createRegistry(2120);
						Naming.rebind("//"+ipServer+":"+porta+"/meuServidor", instanciaServidor);
						instanciaServidor.frame.setVisible(true);
				

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ServidorImp() throws RemoteException{
		IPessoaDAO repositorioPessoa = new PessoaDAOImp();
		IDesafiosDAO repositorioDesafio = new DesafiosDAOImp();
		IGrupoDAO repositoriooGrupo = new GrupoDAOImp();
		IAvaliacoesDAO repositorioAvaliacao = new AvaliacoesDAOImp();

		negocioPessoa = new PessoaBOImp(repositorioPessoa);
		negocioGrupo = new GrupoBOImp(repositoriooGrupo);
		negocioDesafio = new DesafioBOImp(repositorioDesafio);
		negocioAvaliacao = new AvaliacoesBOImp(repositorioAvaliacao);
		HibernateUtil.getSessionFactory();
		
			initialize();
		
		
	}
	

	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 240);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

	@Override
	public void inserirPessoa(Pessoa pessoa) throws BancoException,RemoteException {
		negocioPessoa.inserir(pessoa);
	}

	@Override
	public Pessoa procurarPessoa(String login) throws BancoException, RemoteException {
		return negocioPessoa.procurar(login);
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) throws BancoException , RemoteException{
		negocioPessoa.atualizar(pessoa);
	}

	@Override
	public void removerPessoa(String login) throws BancoException , RemoteException{
		negocioPessoa.remover(login);
	}

	@Override
	public void inserirDesafios(Desafios desafio) throws BancoException, RemoteException {
		negocioDesafio.inserir(desafio);
	}

	@Override
	public Desafios procurarDesafios(String nome) throws BancoException {
		return negocioDesafio.procurar(nome);
	}

	@Override
	public void atualizarDesafios(Desafios desafio) throws BancoException {
		negocioDesafio.atualizar(desafio);
	}

	@Override
	public void removerDesafios(String nome) throws BancoException {
		negocioDesafio.remover(nome);
	}

	@Override
	public void inserirGrupo(Grupo grupo) throws BancoException {
		negocioGrupo.inserir(grupo);
	}

	@Override
	public Grupo procurarGrupo(Integer idGrupo) throws BancoException {
		return negocioGrupo.procurar(idGrupo);
	}

	@Override
	public void atualizarGrupo(Grupo grupo) throws BancoException {
		negocioGrupo.atualizar(grupo);
	}

	@Override
	public void removerGrupo(Integer idGrupo) throws BancoException {
		negocioGrupo.remover(idGrupo);
	}

	@Override
	public void inserirAvaliacoes(Avaliacoes avaliacao) throws BancoException {
		negocioAvaliacao.inserir(avaliacao);
	}

	@Override
	public Avaliacoes procurarAvaliacoes(Integer idAvaliacao) throws BancoException {
		return negocioAvaliacao.procurar(idAvaliacao);
	}

	@Override
	public void atualizarAvaliacoes(Avaliacoes avaliacao) throws BancoException {
		negocioAvaliacao.atualizar(avaliacao);
	}

	@Override
	public void removerAvaliacoes(Integer idAvaliacao) throws BancoException {
		negocioAvaliacao.remover(idAvaliacao);
	}

	@Override
	public List<Pessoa> listaPessoas(TipoPessoa tipoPessoa) {
		return negocioPessoa.listaPessoa(tipoPessoa);
	}

	@Override
	public List<Grupo> listaGrupos() {
		return negocioGrupo.listaGrupos();
	}

	@Override
	public List<Desafios> listaDesafios() {
		return negocioDesafio.listaDesafios();
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException{
		return negocioAvaliacao.listaAvaliacoesPorAvaliador(pessoa);
	}

	@Override
	public Desafios desafioAtivo() {
		Desafios desafio = negocioDesafio.desafioAtivo();
		return desafio;
	}

	@Override
	public List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo, String login) throws BancoException {
		return negocioGrupo.listaGruposPorSerie(serie, desafioAtivo, login);
	}

	@Override
	public void gerarExcelAvaliacoes(Desafios desafio) throws FileNotFoundException, IOException {
		negocioAvaliacao.gerarExcelAvaliacoes(desafio);
	}

	@Override
	public List<Desafios> listaDesafiosAvaliados() {
		return negocioDesafio.listaDesafiosAvaliados();
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesOrdemDct() {
		return negocioAvaliacao.listaAvaliacoesOrdemDct();
	}


	public String getDiretorioVideo() {
		return diretorioVideo;
	}

	public void setDiretorioVideo(String diretorioVideo) {
		this.diretorioVideo = diretorioVideo;
	}

	@Override
	public List<Pessoa> listaDePessasNaSerie(String serie) {
		
		return (List<Pessoa>) negocioPessoa.listaDePessasNaSerie(serie);
	}


}
