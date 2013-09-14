package masterfila.repositorio;

import java.util.List;

import masterfila.dao.Dao;
import masterfila.entidade.TipoFicha;
import masterfila.util.Constants;

public class RepositorioTipoFicha {

	private Dao dao;
	
	public RepositorioTipoFicha(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(TipoFicha novo){
		novo.setStatus(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(TipoFicha atual){
		dao.atualizarObjeto(atual);
	}
	
	public List<TipoFicha> listar(){
		return (List<TipoFicha>) dao.criarQuery("FROM tipo_ficha WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	public void remover(TipoFicha del){
		del.setStatus(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	public boolean existeNome(String nome){
		TipoFicha retorno = (TipoFicha) dao.buscarPorChaveUnicaString(TipoFicha.class, nome, "nome");
		if(retorno != null){
			return true;
		}
		else{
			return false;
		}
	}
}
