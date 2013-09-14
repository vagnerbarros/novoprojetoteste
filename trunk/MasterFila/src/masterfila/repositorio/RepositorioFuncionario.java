package masterfila.repositorio;

import java.util.List;

import masterfila.dao.Dao;
import masterfila.entidade.Funcionario;
import masterfila.util.Constants;

public class RepositorioFuncionario {

	private Dao dao;
	
	public RepositorioFuncionario(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Funcionario novo){
		novo.setStatus(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Funcionario atual){
		dao.atualizarObjeto(atual);
	}
	
	public List<Funcionario> listar(){
		return (List<Funcionario>) dao.criarQuery("FROM funcionario WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	public void remover(Funcionario del){
		del.setStatus(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	public Funcionario buscarLoginSenha(String login, String senha){
		List<Funcionario> lista = (List<Funcionario>)dao.criarQuery("FROM funcionario where login LIKE '"+ login +"' AND senha LIKE '"+ senha +"'  AND status <> '" + Constants.INATIVO + "'");
		if(!lista.isEmpty()){
			return lista.get(0);
		}
		else{
			return null;
		}
	}
	
	public List<Funcionario> buscarNome(String nome){
		return (List<Funcionario>) dao.buscarPorLikeIgnoreCase("nome", nome, Funcionario.class);
	}
	
	public List<Funcionario> buscarCpf(String cpf){
		return (List<Funcionario>) dao.buscarPorLikeIgnoreCase("cpf", cpf, Funcionario.class);
	}
	
	public boolean existeLogin(String login){
		Funcionario retorno = (Funcionario) dao.buscarPorChaveUnicaString(Funcionario.class, login, "login");
		if(retorno != null){
			return true;
		}
		else{
			return false;
		}
	}
}
