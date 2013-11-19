package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;
import masterfila.util.Constants;

public class Cadastrar implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String json = request.getParameter("json");
		
		Usuario novo = consumirJson(json);
		novo.setStatus(Constants.INATIVO);
		
		Estabelecimento estab = Fachada.getInstance().cadastroEmpresa().buscarId(Long.parseLong("1"));
		novo.setEmpresa(estab);
		Fachada fachada = Fachada.getInstance();
		fachada.cadastroUsuario().cadastrar(novo);
		
		String paginaRetorno = "/cadastro_sucesso.jsp";
		return paginaRetorno;
	}
	
	private Usuario consumirJson(String json){
		
		Usuario u = new Usuario();
		u.setNome("nome");
		u.setCpf("cpf");
		u.setLogin("email");
		u.setSenha("senha");
		u.setRua("rua");
		return u;
	}
}
