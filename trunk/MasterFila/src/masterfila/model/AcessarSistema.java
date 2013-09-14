package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcessarSistema implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		String cidade = request.getParameter("cidades");
		String estado = request.getParameter("estados");
		request.getSession().setAttribute("cidade", cidade);
		request.getSession().setAttribute("estado", estado);
		return "/home.jsp";
	}

}
