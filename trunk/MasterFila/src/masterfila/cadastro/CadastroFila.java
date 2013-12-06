package masterfila.cadastro;

import java.util.List;

import masterfila.entidade.Fila;
import masterfila.entidade.TipoFicha;
import masterfila.repositorio.RepositorioFila;

public class CadastroFila {

	private RepositorioFila rep;
	
	public CadastroFila(RepositorioFila rep){
		this.rep = rep;
	}
	
	public void cadastrar(Fila novo) {
		boolean existeFila = rep.existeFila(novo);
		if(!existeFila){
			rep.inserir(novo);
		}
		else{
			rep.atualizar(novo);
		}
	}
	
	public void atualizar(Fila atual){
		rep.atualizar(atual);
	}
	
	public void remover(Fila deletado){
		rep.remover(deletado);
	}
	
	public List<Fila> listar(){
		return rep.listar();
	}
	
	public Fila buscarFila(TipoFicha tipo){
		return rep.buscarTipo(tipo);
	}
}
