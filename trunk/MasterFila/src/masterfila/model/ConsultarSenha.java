package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Estabelecimento;
import masterfila.fachada.Fachada;

public class ConsultarSenha implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String pagina = "chamada_senha.jsp?id_fila=Normal";
		
		String idEstab = request.getParameter("id");
		Estabelecimento estab = Fachada.getInstance().cadastroEmpresa().buscarId(Long.parseLong(idEstab));
		if(estab != null){
			request.getSession().setAttribute("estabelecimento", estab);
		}
		
		
		return pagina;
	}

	
}
