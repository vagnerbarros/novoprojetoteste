package masterfila.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.model.Acao;
import masterfila.model.AcessarSistema;
import masterfila.model.AtivarEmpresa;
import masterfila.model.Cadastrar;
import masterfila.model.CadastrarEmpresa;
import masterfila.model.ConsultarSenha;
import masterfila.model.Editar;
import masterfila.model.Erro;
import masterfila.model.EscolherCategoria;
import masterfila.model.HistoricoAndroid;
import masterfila.model.InativaEmpresa;
import masterfila.model.ListarEmpresa;
import masterfila.model.ListarEmpresasJSON;
import masterfila.model.LogOut;
import masterfila.model.Logar;
import masterfila.model.LogarAndroid;
import masterfila.model.MudarStatusCliente;
import masterfila.model.RecuperarEmail;
import masterfila.model.RecuperarSenha;
import masterfila.model.SolicitarSenhaAndroid;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/controlador")
public class ServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Acao> mapa;

	public ServletController() {
		super();
		mapa = new HashMap<String, Acao>();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		mapa.put("logar", new Logar());
		mapa.put("cadastrar", new Cadastrar());
		mapa.put("acessarSistema", new AcessarSistema());
		mapa.put("categoria", new EscolherCategoria());
		mapa.put("editar", new Editar());
		mapa.put("recuperar_email", new RecuperarEmail());
		mapa.put("logout", new LogOut());
		mapa.put("cadastrar_empresa", new CadastrarEmpresa());
		mapa.put("inativar_empresa", new InativaEmpresa());
		mapa.put("ativar_empresa", new AtivarEmpresa());
		mapa.put("mudar_status", new MudarStatusCliente());
		mapa.put("consultar_senha", new ConsultarSenha());
		mapa.put("logar_android", new LogarAndroid());
		mapa.put("listar_android", new ListarEmpresasJSON());
		mapa.put("recuperar_senha", new RecuperarSenha());
		mapa.put("listarEmpresas", new ListarEmpresa());
		mapa.put("historico_android", new HistoricoAndroid());
		mapa.put("solicitar_senha", new SolicitarSenhaAndroid());
		
		mapa.put("erro", new Erro());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Acao classeAcao = buscarAcao(acao);
		String proximaPagina = classeAcao.executar(request, response);
		if(!proximaPagina.equals("")){
			RequestDispatcher dispatcher = request.getRequestDispatcher(proximaPagina);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Acao buscarAcao(String acao) {
		Acao resultado = mapa.get(acao);
		if (resultado == null) {
			resultado = mapa.get("erro");
		}
		return resultado;
	}
}
