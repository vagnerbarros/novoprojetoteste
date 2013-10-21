package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Funcionario;
import masterfila.fachada.Fachada;

public class Editar implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		Funcionario funcionario = (Funcionario) request.getSession().getAttribute("usuario");
		funcionario.setNome(nome);
		funcionario.setSenha(senha);
		
		Fachada fachada = Fachada.getInstance();
		fachada.cadastroFuncionario().atualizar(funcionario);
		
		request.getSession().setAttribute("usuario", funcionario);
		
		return "atualizar_sucesso.jsp";
	}

}
