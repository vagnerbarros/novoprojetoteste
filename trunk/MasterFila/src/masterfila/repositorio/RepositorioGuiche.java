package masterfila.repositorio;

import java.util.List;

import masterfila.dao.Dao;
import masterfila.dominio.SituacaoGuiche;
import masterfila.entidade.Funcionario;
import masterfila.entidade.Guiche;
import masterfila.util.Constants;

public class RepositorioGuiche {

	private Dao dao;
	
	public RepositorioGuiche(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Guiche novo){
		novo.setStatus(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Guiche atual){
		dao.atualizarObjeto(atual);
	}
	
	public List<Guiche> listar(){
		return (List<Guiche>) dao.criarQuery("FROM guiche WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	public List<Guiche> listarDisponiveis(){
		return (List<Guiche>) dao.buscarPorLike("situacao", SituacaoGuiche.LIVRE, Guiche.class);
	}
	
	public void remover(Guiche del){
		del.setStatus(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	public boolean existeNumero(String numero){
		Guiche retorno = (Guiche) dao.buscarPorChaveUnicaString(Guiche.class, numero, "numero");
		if(retorno != null){
			return true;
		}
		else{
			return false;
		}
	}
}
