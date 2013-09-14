package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;

public class Editar implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setRua(endereco);
		usuario.setBairro(email);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		Fachada fachada = Fachada.getInstance();
		fachada.cadastroUsuario().atualizar(usuario);
		
		return "atualizar_sucesso.jsp";
	}

}
