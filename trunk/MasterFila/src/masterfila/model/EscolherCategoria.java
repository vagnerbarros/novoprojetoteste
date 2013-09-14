package masterfila.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EscolherCategoria implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		String categoria = request.getParameter("categoria");
		request.getSession().setAttribute("categoria_escolhida", categoria);
		return "/home.jsp";
	}

}
