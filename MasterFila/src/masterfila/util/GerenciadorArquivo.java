package masterfila.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Ficha;

public class GerenciadorArquivo {

	private Estabelecimento estabelecimento;
	private List<Ficha> historico;
	private File arquivo;
	private String nomeArquivo = "Normal";
	
	public GerenciadorArquivo(String tipoFila){
		historico = new ArrayList<Ficha>();
	}
	
	public static void criarArquivo(String tipoFila){
		File a = new File(Constants.CAMINHO_ARQUIVO + tipoFila + ".jsp");
		try {
			boolean criou = a.createNewFile();
			if(criou){
				System.out.println("Arquivo Criado");
			}
			else{
				System.out.println("Arquivo não criado");
			}
		} catch (IOException e) {
			
		}
	}
	
	public void adicionar(Ficha ficha){
		historico.add(ficha);
		atualizarArquivo(ficha.getNumero());
	}
	
	private void atualizarArquivo(String numero){
		
		File inicio = new File(Constants.CAMINHO_ARQUIVO + "1.jsp");
		File fim = new File(Constants.CAMINHO_ARQUIVO + "2.jsp");
		try {
			FileReader frInicio = new FileReader(inicio);
			BufferedReader brInicio = new BufferedReader(frInicio);
			String conteudoArquivo = "";
			while(brInicio.ready()){
				conteudoArquivo += brInicio.readLine();
			}
			
			conteudoArquivo += numero;
			
			FileReader frFim = new FileReader(fim);
			BufferedReader brFim = new BufferedReader(frFim);
			while(brFim.ready()){
				conteudoArquivo += brFim.readLine();
			}
			
			brInicio.close();
			brFim.close();
			
			arquivo = new File(Constants.CAMINHO_ARQUIVO + nomeArquivo + ".jsp");
			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(conteudoArquivo);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
