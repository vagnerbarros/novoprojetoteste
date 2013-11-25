package masterfila.repositorio;

import java.util.List;

import masterfila.dao.Dao;
import masterfila.entidade.Estabelecimento;
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
		//novo.setStatus(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Usuario atual){
		dao.atualizarObjeto(atual);
	}
	
	public List<Usuario> listar(){
		return (List<Usuario>) dao.criarQuery("FROM usuario WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	public List<Usuario> listarPorEmpresaAtivos(long id_empresa){
		return (List<Usuario>) dao.criarQuery("FROM usuario WHERE id_empresa = " + id_empresa + " AND status <> '" + Constants.INATIVO + "'");
	}
	
	public List<Usuario> listarPorEmpresaInativos(long id_empresa){
		return (List<Usuario>) dao.criarQuery("FROM usuario WHERE id_empresa = " + id_empresa + " AND status <> '" + Constants.ATIVO + "'");
	}
	
	
	public void mudarStatus(Usuario usuario){
		Usuario u = buscarPorId(usuario.getId());
		if(u != null){
			if(u.getStatus().equals(Constants.ATIVO)){
				u.setStatus(Constants.INATIVO);
			}
			else if(u.getStatus().equals(Constants.INATIVO)){				
				u.setStatus(Constants.ATIVO);
			}
			dao.atualizarObjeto(u);
		}
	}
	
	public Usuario buscarPorId(long id){
		List<Usuario> lista = (List<Usuario>) dao.criarQuery("FROM usuario WHERE id = " + id);
		if(lista != null){
			return lista.get(0);
		}
		else{
			return null;
		} 
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

	public Usuario buscarPorLogin(String login) {
		List<Usuario> lista = (List<Usuario>) dao.criarQuery("FROM usuario WHERE login LIKE '" + login + "' AND status <> '" + Constants.INATIVO + "'");
		if(lista != null){
			return lista.get(0);
		}
		else{
			return null;
		}
	}
}
