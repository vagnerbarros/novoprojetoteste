package masterfila.cadastro;

import java.util.List;

import masterfila.entidade.Fila;
import masterfila.entidade.TipoFicha;
import masterfila.exception.FilaExistenteException;
import masterfila.exception.TipoAtendimentoExisteException;
import masterfila.fachada.Fachada;
import masterfila.repositorio.RepositorioTipoFicha;

public class CadastroTipoFicha {

	private RepositorioTipoFicha rep;
	
	public CadastroTipoFicha(RepositorioTipoFicha rep){
		this.rep = rep;
	}
	
	public void cadastrar(TipoFicha novo) throws TipoAtendimentoExisteException, FilaExistenteException{
		boolean existeNome = rep.existeNome(novo.getNome());
		if(!existeNome){
			rep.inserir(novo);
			Fachada fachada = Fachada.getInstance();
			Fila fila = new Fila(novo);
			fachada.cadastroFila().cadastrar(fila);
		}
		else{
			throw new TipoAtendimentoExisteException();
		}
	}
	
	public void atualizar(TipoFicha atual){
		rep.atualizar(atual);
	}
	
	public void remover(TipoFicha deletado){
		rep.remover(deletado);
	}
	
	public List<TipoFicha> listar(){
		return rep.listar();
	}
}
