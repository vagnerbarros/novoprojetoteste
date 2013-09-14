package masterfila.repositorio;

import java.util.List;

import masterfila.dao.Dao;
import masterfila.entidade.Ficha;
import masterfila.entidade.Usuario;
import masterfila.util.Constants;

public class RepositorioUsuario {

	private Dao dao;
	
	public RepositorioUsuario(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Usuario novo){
		novo.setStatus(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Usuario atual){
		dao.atualizarObjeto(atual);
	}
	
	public List<Usuario> listar(){
		return (List<Usuario>) dao.criarQuery("FROM usuario WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	public void remover(Usuario del){
		del.setStatus(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}

	public Usuario logar(String login, String senha) {
		List<Usuario> lista = (List<Usuario>)dao.criarQuery("FROM usuario where login LIKE '"+ login +"' AND senha LIKE '"+ senha +"'  AND status <> '" + Constants.INATIVO + "'");
		if(!lista.isEmpty()){
			return lista.get(0);
		}
		else{
			return null;
		}
	}
}
