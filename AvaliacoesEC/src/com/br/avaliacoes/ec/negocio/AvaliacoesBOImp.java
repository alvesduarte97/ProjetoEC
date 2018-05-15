package com.br.avaliacoes.ec.negocio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.br.avaliacoes.ec.DAO.IAvaliacoesDAO;
import com.br.avaliacoes.ec.excecoes.BancoException;
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
		
		List<Avaliacoes> listaAgresteM = new ArrayList<>();
		List<Avaliacoes> listaSertaoM = new ArrayList<>();
		List<Avaliacoes> listaMetroM = new ArrayList<>();
		List<Avaliacoes> listaZonaM = new ArrayList<>();
		
		listaMedias(listaAgreste, listaAgresteM);
		listaMedias(listaSertao, listaSertaoM);
		listaMedias(listaMetro, listaMetroM);
		listaMedias(listaZona, listaZonaM);
				
		
		//Para excel com todas as avaliacoes
		HSSFWorkbook workbook = new HSSFWorkbook();
		//Para excel com media de avaliacoes
		HSSFWorkbook newWorkbook = new HSSFWorkbook();
		//Para excel com todas as avaliacoes
		FileOutputStream fos = null;
		//Para excel com media de avaliacoes
		FileOutputStream newFos =  null;
		
		
		Date data = new Date();
		DateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatarData.format(data);
		fos = new FileOutputStream(desafio.getNome() +" "+dataFormatada.replaceAll("/", ".")+".xls");
		newFos =  new FileOutputStream(desafio.getNome() +"Media"+" "+dataFormatada.replaceAll("/", ".")+".xls");
		
		gerarTabelas("Agreste", listaAgreste, listaAgresteM, workbook,newWorkbook);
		gerarTabelas("Sertao", listaSertao,listaSertaoM, workbook,newWorkbook);
		gerarTabelas("Metropolitana", listaMetro,listaMetroM, workbook,newWorkbook);
		gerarTabelas("Zona da mata", listaZona,listaZonaM, workbook,newWorkbook);
		
		workbook.write(fos);
		newWorkbook.write(newFos);
		
		newFos.flush();
		fos.flush();
		
		newFos.close();
		fos.close();
		
		
		
		
	}
	private void gerarTabelas(String regiao, List<Avaliacoes> lista,List<Avaliacoes> listaM, HSSFWorkbook workbook, HSSFWorkbook outroWorkbook) {
		//Criando abas por região
		HSSFSheet firsSheet = workbook.createSheet(regiao);
		HSSFSheet firstSheetNew = outroWorkbook.createSheet(regiao);
		
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
		
		HSSFRow firstRowN = firstSheetNew.createRow(0);
		firstRowN.createCell(1).setCellValue("Serie");
		firstRowN.createCell(2).setCellValue("Escola");
		firstRowN.createCell(3).setCellValue("Desafio");
		firstRowN.createCell(4).setCellValue("Nota Final");

		
		int i = 2;
		HSSFRow jumpRow = firsSheet.createRow(i-1);
		
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
		
		int y = 2;
		HSSFRow jumpRowN = firstSheetNew.createRow(y-1);
		
		for(Avaliacoes ava : listaM) {
			
			HSSFRow rowN = firstSheetNew.createRow(i);
			rowN.createCell(1).setCellValue(ava.getGrupoAvaliado().getSerie());
			rowN.createCell(2).setCellValue(ava.getGrupoAvaliado().getEscola());
			rowN.createCell(3).setCellValue(ava.getDesafio().getNome());
			rowN.createCell(9).setCellValue(ava.getNotaFinal());
			
			y++;
		}
		
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesOrdemDct() {
		return repositorio.listaAvaliacoesOrdemDct();
	}
	
	public List <Avaliacoes> listaMedias(List<Avaliacoes> listaPrincipal, List<Avaliacoes> listMedia) {
		for(int i = 0; i < listaPrincipal.size(); i +=2) {
			if(listaPrincipal.get(i).getGrupoAvaliado().getEscola().equals(listaPrincipal.get(i + 1).getGrupoAvaliado().getEscola()) && listaPrincipal.get(i).getGrupoAvaliado().getSerie().equals(listaPrincipal.get(i+1).getGrupoAvaliado().getSerie())) {
				Avaliacoes ava = new Avaliacoes();
				ava.setNotaFinal((listaPrincipal.get(i).getNotaFinal() + listaPrincipal.get(i+1).getNotaFinal())/2);
				ava.setGrupoAvaliado(listaPrincipal.get(i).getGrupoAvaliado());
				ava.setDesafio(listaPrincipal.get(i).getDesafio());
				listMedia.add(ava);
			}else {
				listMedia.add(listaPrincipal.get(i));
			}
		}
		
		
		
		return null;
	}
	
	}


