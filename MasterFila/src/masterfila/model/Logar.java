package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;

public class Logar implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Fachada fachada = Fachada.getInstance();
		Usuario usuario = fachada.cadastroUsuario().logar(login, senha);
		if(usuario != null){
			request.getSession().setAttribute("usuario", usuario);
			return "/home.jsp";
		}
		else{
			return "index.jsp";
		}
	}

}
