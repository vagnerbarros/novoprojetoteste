package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecuperarEmail implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "recuperar_email_sucesso.jsp";
	}

}
