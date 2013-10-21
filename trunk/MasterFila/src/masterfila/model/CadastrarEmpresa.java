package masterfila.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.dominio.Perfil;
import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Funcionario;
import masterfila.exception.CpfExistenteException;
import masterfila.exception.LoginExistenteException;
import masterfila.fachada.Fachada;

public class CadastrarEmpresa implements Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String pagina = "gestao_empresa.jsp";
		
		String categoria = request.getParameter("categoria");
		String cidade = request.getParameter("cidade");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String estado = request.getParameter("estado");
		String nome = request.getParameter("nome");
		String razao = request.getParameter("razao");
		
		Estabelecimento estab = new Estabelecimento();
		estab.setCategoria(categoria);
		estab.setCidade(cidade);
		estab.setCnpj(cnpj);
		estab.setEmail(email);
		estab.setEndereco(endereco);
		estab.setEstado(estado);
		estab.setNome(nome);
		estab.setRazao(razao);
		
		Funcionario gerente = new Funcionario();
		gerente.setLogin(estab.getEmail());
		gerente.setSenha(estab.getCnpj());
		gerente.setPerfil(Perfil.GERENTE);
		gerente.setEstabelecimento(estab);
		
		Fachada.getInstance().cadastroEmpresa().cadastrar(estab);
		try {
			Fachada.getInstance().cadastroFuncionario().cadastrar(gerente);
		} catch (LoginExistenteException e) {
			e.printStackTrace();
		} catch (CpfExistenteException e) {
			e.printStackTrace();
		}
		
		return pagina;
	}
}
