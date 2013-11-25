package masterfila.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Ficha;
import masterfila.entidade.Fila;
import masterfila.entidade.TipoFicha;
import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;
import masterfila.util.CarregarDados;

import org.json.simple.JSONObject;

public class SolicitarSenhaAndroid implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String login = request.getParameter("login");
		if(login != null && !login.equals("")){
			
			Fachada fachada = Fachada.getInstance();
			CarregarDados.go();
			List<TipoFicha> tipos = fachada.cadastroTipoFicha().listar();
			Usuario cliente = fachada.cadastroUsuario().buscarLogin(login);
			Fila fila = null;
			for(TipoFicha tipo : tipos){
				if(tipo.getNome().equalsIgnoreCase("Normal")){
					fila = fachada.cadastroFila().buscarFila(tipo);
				}
			}
			
			Ficha ficha = fila.solicitarFicha();
			ficha.setCliente(cliente);
			fachada.cadastroFicha().cadastrar(ficha);
			
			String json = gerarJSONFicha(ficha);
			PrintWriter print;
			try {
				print = response.getWriter();
				print.print(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	private String gerarJSONFicha(Ficha ficha) {
		
		JSONObject json = new JSONObject();
		json.put("numero", ficha.getNumero());
		return json.toString();
	}
}
