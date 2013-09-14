package masterfila.cadastro;

import java.util.List;

import masterfila.dominio.SituacaoGuiche;
import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Guiche;
import masterfila.exception.NumeroGuicheExisteException;
import masterfila.repositorio.RepositorioGuiche;

public class CadastroGuiche {

	private RepositorioGuiche rep;
	
	public CadastroGuiche(RepositorioGuiche rep){
		this.rep = rep;
	}
	
	public void cadastrar(Guiche novo) throws NumeroGuicheExisteException{
		novo.setSituacao(SituacaoGuiche.LIVRE);
		boolean existeNumero = rep.existeNumero(novo.getNumero());
		if(!existeNumero){
			rep.inserir(novo);
		}
		else{
			throw new NumeroGuicheExisteException();
		}
	}
	
	public void atualizar(Guiche atual){
		rep.atualizar(atual);
	}
	
	public void remover(Guiche deletado){
		rep.remover(deletado);
	}
	
	public List<Guiche> listar(){
		return rep.listar();
	}
	
	public List<Guiche> listarDisponiveis(){
		return rep.listarDisponiveis();
	}
	
	public void fecharGuiche(Guiche guiche){
		guiche.setSituacao(SituacaoGuiche.FUNCIONANDO);
		atualizar(guiche);
	}

	public void abrirGuiche(Guiche guiche) {
		guiche.setSituacao(SituacaoGuiche.LIVRE);
		atualizar(guiche);
	}
}
