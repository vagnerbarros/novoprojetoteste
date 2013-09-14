package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;

public class Cadastrar implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario novo = new Usuario();
		novo.setNome(nome);
		novo.setCpf(cpf);
		novo.setRua(endereco);
		novo.setBairro(email);
		novo.setLogin(login);
		novo.setSenha(senha);
		
		String paginaRetorno = "/cadastro_sucesso.jsp";
		Fachada fachada = Fachada.getInstance();
		fachada.cadastroUsuario().cadastrar(novo);
		return paginaRetorno;
	}

}
