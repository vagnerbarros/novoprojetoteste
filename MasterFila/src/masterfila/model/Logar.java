package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Funcionario;
import masterfila.exception.LoginSenhaIncorretosException;
import masterfila.fachada.Fachada;

public class Logar implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Fachada fachada = Fachada.getInstance();
		Funcionario funcionario;
		try {
			funcionario = fachada.cadastroFuncionario().logar(login, senha);
			request.getSession().setAttribute("usuario", funcionario);
			return "/home.jsp";
		} catch (LoginSenhaIncorretosException e) {
			return "index.jsp?msg=" + e.getMessage();
		}

	}

}
