package masterfila.cadastro;

import java.util.List;

import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Usuario;
import masterfila.repositorio.RepositorioUsuario;
import masterfila.util.Criptografia;

public class CadastroUsuario {

	private RepositorioUsuario rep;
	
	public CadastroUsuario(RepositorioUsuario rep){
		this.rep = rep;
	}
	
	public void cadastrar(Usuario novo){
		String senha = Criptografia.encryptPassword(novo.getSenha());
		novo.setSenha(senha);
		rep.inserir(novo);
	}
	
	public void atualizar(Usuario atual){
		rep.atualizar(atual);
	}
	
	public void remover(Usuario deletado){
		rep.remover(deletado);
	}
	
	public List<Usuario> listar(){
		return rep.listar();
	}

	public Usuario logar(String login, String senha) {
		senha = Criptografia.encryptPassword(senha);
		return rep.logar(login, senha);
	}
	
	public boolean logarAndroid(String login, String senha){
		Usuario u = rep.logar(login, senha);
		if(u != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public List<Usuario> listarPorEmpresaAtivos(Estabelecimento e){
		return rep.listarPorEmpresaAtivos(e.getId());
	}
	
	public List<Usuario> listarPorEmpresaInativos(Estabelecimento e){
		return rep.listarPorEmpresaInativos(e.getId());
	}
	
	public void mudarStatus(Usuario u){
		rep.mudarStatus(u);
	}

	public Usuario buscarLogin(String login) {
		return rep.buscarPorLogin(login);
	}
}
