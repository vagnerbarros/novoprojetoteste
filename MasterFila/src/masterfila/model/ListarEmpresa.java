package masterfila.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Estabelecimento;
import masterfila.fachada.Fachada;

public class ListarEmpresa implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		Fachada fachada = Fachada.getInstance();
		List<Estabelecimento> lista = fachada.cadastroEmpresa().listar();
		request.setAttribute("empresas", lista);
		String pagina = "listarEmpresa.jsp";
		return pagina;
	}
}
