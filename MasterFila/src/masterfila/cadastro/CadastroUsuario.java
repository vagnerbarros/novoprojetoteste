package masterfila.cadastro;

import java.util.List;

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
}
