package masterfila.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import masterfila.exception.FichaInvalidaException;
import masterfila.exception.FilaVaziaException;
import masterfila.util.GerenciadorArquivo;

public class Fila {

	private List<Ficha> fichas;
	private int indice;
	private int proximo;
	private TipoFicha tipo;
	private GerenciadorArquivo gerenciadorArquivo;
	
	public Fila(TipoFicha tipo){
		this.tipo = tipo;
		proximo = 0;
		indice = 0;
		fichas = new ArrayList<Ficha>();
		gerenciadorArquivo = new GerenciadorArquivo(tipo.getNome());
	}
	
	public void setFichas(List<Ficha> fichas){
		if(fichas != null){
			this.fichas = fichas;
			indice = fichas.size();
		}
	}
	
	public void adicionarFicha(Ficha ficha) throws FichaInvalidaException{
		if(tipo.equals(ficha.getTipo())){
			fichas.add(indice, ficha);
			indice++;
		}
		else{
			throw new FichaInvalidaException();
		}
	}
	
	public Ficha solicitarFicha(){
		Ficha retorno = new Ficha();
		retorno.setData(new Date());
		retorno.setNumero(gerarNumero());
		retorno.setTipo(tipo);
		try {
			adicionarFicha(retorno);
		} catch (FichaInvalidaException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	private String gerarNumero(){
		String t = tipo.getNome();
		String retorno = t.substring(0, 1) + indice;
		return retorno;
	}
	
	public Ficha atenderProximo() throws FilaVaziaException{
		Ficha retorno = null;
		if(fichas != null && !fichas.isEmpty() && proximo < indice){
			retorno = fichas.get(proximo);
			proximo++;
		}
		else{
			throw new FilaVaziaException();
		}
		return retorno;
	}
	
	public TipoFicha getTipo(){
		return tipo;
	}
	
	public boolean equals(Object o){
		if(this.tipo.equals(((Fila)o).getTipo())){
			return true;
		}
		else{
			return false;
		}
	}
}
