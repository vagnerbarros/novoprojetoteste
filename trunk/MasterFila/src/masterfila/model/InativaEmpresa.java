package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Estabelecimento;
import masterfila.fachada.Fachada;

public class InativaEmpresa implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String pagina = "gestao_empresa.jsp";
		
		String id = request.getParameter("id");
		if(id != null & !id.equals("")){
			long idDel = Long.parseLong(id);
			Estabelecimento estab = new Estabelecimento();
			estab.setId(idDel);
			Fachada.getInstance().cadastroEmpresa().remover(estab);
		}
		
		return pagina;
	}

}
