package com.br.avaliacoes.ec.negocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.br.avaliacoes.ec.DAO.IAvaliacoesDAO;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.Regiao;

public class AvaliacoesBOImp implements IAvaliacoesBO {

	private IAvaliacoesDAO repositorio;
	
	public AvaliacoesBOImp(IAvaliacoesDAO repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public void inserir(Avaliacoes entity) throws BancoException {
		if(entity.getComentario().length() < 20)
			throw new BancoException("Por favor insira um comentario maior");
		repositorio.inserir(entity);
	}

	@Override
	public Avaliacoes procurar(Integer chave) throws BancoException {
		return repositorio.procurar(chave);
	}

	@Override
	public void atualizar(Avaliacoes entity) throws BancoException {
		repositorio.atualizar(entity);
	}

	@Override
	public void remover(Integer chave) throws BancoException {
		repositorio.remover(chave);
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException{
		return repositorio.listaAvaliacoesPorAvaliador(pessoa);
	}

	@Override
	public void gerarExcelAvaliacoes(Desafios desafio) throws IOException {
		List<Avaliacoes> listaAgreste = repositorio.listaAvaliacoes(Regiao.AGRESTE, desafio);
		List<Avaliacoes> listaSertao = repositorio.listaAvaliacoes(Regiao.SERTAO, desafio);
		List<Avaliacoes> listaMetro = repositorio.listaAvaliacoes(Regiao.METROPOLITANA, desafio);
		List<Avaliacoes> listaZona = repositorio.listaAvaliacoes(Regiao.ZONADAMATA, desafio);
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		FileOutputStream fos = null;
		Date data = new Date();
		DateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatarData.format(data);
		fos = new FileOutputStream(desafio.getNome() +" "+dataFormatada.replaceAll("/", ".")+".xls");
		
		gerarTabelas("Agreste", listaAgreste, workbook);
		gerarTabelas("Sertao", listaSertao, workbook);
		gerarTabelas("Metropolitana", listaMetro, workbook);
		gerarTabelas("Zona da mata", listaZona, workbook);
		
		workbook.write(fos);
		fos.flush();
		fos.close();
		
		
		
		
	}
	private void gerarTabelas(String regiao, List<Avaliacoes> lista, HSSFWorkbook workbook) {
		HSSFSheet firsSheet = workbook.createSheet(regiao);
		HSSFRow firstRow = firsSheet.createRow(0);
		firstRow.createCell(1).setCellValue("Serie");
		firstRow.createCell(2).setCellValue("Escola");
		firstRow.createCell(3).setCellValue("Desafio");
		firstRow.createCell(4).setCellValue("Nota 1");
		firstRow.createCell(5).setCellValue("Nota 2");
		firstRow.createCell(6).setCellValue("Nota 3");
		firstRow.createCell(7).setCellValue("Nota 4");
		firstRow.createCell(8).setCellValue("Nota 5");
		firstRow.createCell(9).setCellValue("Nota Final");
		firstRow.createCell(10).setCellValue("Comentario");
		
		int i = 1;
		for(Avaliacoes ava : lista) {
			HSSFRow Row = firsSheet.createRow(i);
//			double notaFinal = ava.getNota1() + ava.getNota2() + ava.getNota3() + ava.getNota4()+ ava.getNota5();
			Row.createCell(1).setCellValue(ava.getGrupoAvaliado().getSerie());
			Row.createCell(2).setCellValue(ava.getGrupoAvaliado().getEscola());
			Row.createCell(3).setCellValue(ava.getDesafio().getNome());
			Row.createCell(4).setCellValue(ava.getNota1());
			Row.createCell(5).setCellValue(ava.getNota2());
			Row.createCell(6).setCellValue(ava.getNota3());
			Row.createCell(7).setCellValue(ava.getNota4());
			Row.createCell(8).setCellValue(ava.getNota5());
			Row.createCell(9).setCellValue(ava.getNotaFinal());
			Row.createCell(10).setCellValue(ava.getComentario());
			i++;
			
		}
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesOrdemDct() {
		return repositorio.listaAvaliacoesOrdemDct();
	}

}
