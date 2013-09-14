package masterfila.repositorio;

import java.util.ArrayList;
import java.util.List;

import masterfila.entidade.Fila;
import masterfila.entidade.TipoFicha;

public class RepositorioFila {

	private List<Fila> filas;
	
	public RepositorioFila(){
		filas = new ArrayList<Fila>();
	}
	
	public void inserir(Fila nova){
		filas.add(nova);
	}
	
	public void atualizar(Fila atual){
		int index = buscar(atual);
		if(index != -1){
			filas.remove(index);
			filas.add(index, atual);
		}
	}
	
	public List<Fila> listar(){
		return filas;
	}
	
	public void remover(Fila del){
		filas.remove(del);
	}
	
	public boolean existeFila(Fila f){
		int index = buscar(f);
		if(index == -1){
			return false;
		}
		else{
			return true;
		}
	}
	
	public Fila buscarTipo(TipoFicha tipo){
		Fila retorno = null;
		for(Fila f : filas){
			if(f.getTipo().equals(tipo)){
				retorno = f;
			}
		}
		return retorno;
	}
	
	private int buscar(Fila f){
		int retorno = -1;
		for(int i = 0; i < filas.size(); i++){
			if(filas.get(i).equals(f)){
				retorno = i;
			}
		}
		return retorno;
	}
}
