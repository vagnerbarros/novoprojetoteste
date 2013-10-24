package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;

public class MudarStatusCliente implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String pagina = request.getParameter("pagina");
		if(pagina != null){
			if(pagina.equals("i")){
				pagina = "gestao_de_clientes_minha_empresa.jsp";
			}
			else if(pagina.equals("a")){
				pagina = "gestao_de_clientes_vincular.jsp";
			}
		}
		
		String id = request.getParameter("id");
		if(id != null && !id.equals("")){
			
			long idDel = Long.parseLong(id);
			Usuario usuario = new Usuario();
			usuario.setId(idDel);
			
			Fachada.getInstance().cadastroUsuario().mudarStatus(usuario);
		}
		
		return pagina;
	}

}
