package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOut implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "index.jsp";
	}

}
