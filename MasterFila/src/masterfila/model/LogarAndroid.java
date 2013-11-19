package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.fachada.Fachada;

public class LogarAndroid implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		Fachada fachada = Fachada.getInstance();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(!login.equals("") && !senha.equals("")){
			boolean ok = fachada.cadastroUsuario().logarAndroid(login, senha);
			if(ok){
				response.setStatus(200);
			}
			else{
				response.setStatus(400);
			}
		}
		else{
			response.setStatus(400);
		}
		
		return "";
	}

}
