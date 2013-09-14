package masterfila.cadastro;

import java.util.List;

import masterfila.entidade.Funcionario;
import masterfila.exception.ConfirmacaoSenhaException;
import masterfila.exception.LoginExistenteException;
import masterfila.exception.LoginSenhaIncorretosException;
import masterfila.repositorio.RepositorioFuncionario;

public class CadastroFuncionario {

	private RepositorioFuncionario rep;
	
	public CadastroFuncionario(RepositorioFuncionario rep){
		this.rep = rep;
	}
	
	public void verificarSenhaConfirmacao(String senha, String confirmacao) throws ConfirmacaoSenhaException{
		if(!senha.equals(confirmacao)){
			throw new ConfirmacaoSenhaException();
		}
	}
	
	public void cadastrar(Funcionario novo) throws LoginExistenteException{
		boolean existeLogin = rep.existeLogin(novo.getLogin());
		if(!existeLogin){
			rep.inserir(novo);
		}
		else{
			throw new LoginExistenteException();
		}
	}
	
	public void atualizar(Funcionario atual){
		rep.atualizar(atual);
	}
	
	public void remover(Funcionario deletado){
		rep.remover(deletado);
	}
	
	public List<Funcionario> listar(){
		return rep.listar();
	}
	
	public Funcionario logar(String login, String senha) throws LoginSenhaIncorretosException{
		Funcionario logado = rep.buscarLoginSenha(login, senha);
		if(logado != null){
			return logado;
		}
		else{
			throw new LoginSenhaIncorretosException();
		}
	}
	
	public List<Funcionario> buscarNome(String nome){
		return rep.buscarNome(nome);
	}
	
	public List<Funcionario> buscarCpf(String cpf){
		return rep.buscarCpf(cpf);
	}
}
