package masterfila.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.entidade.Ficha;
import masterfila.fachada.Fachada;
import masterfila.util.Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HistoricoAndroid implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		Fachada fachada = Fachada.getInstance();
		String idEstab = request.getParameter("estabelecimento");
		List<Ficha> fichasHistorico = fachada.cadastroFicha().listarAtendidas();
		List<Ficha> fichasFila = fachada.cadastroFicha().listarNaoAtendidas();
		
		String json = gerarFichasJSON(fichasHistorico, fichasFila);
		PrintWriter print;
		try {
			print = response.getWriter();
			print.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private String gerarFichasJSON(List<Ficha> fichasHistorico, List<Ficha> fichasFila) {
		JSONObject json = new JSONObject();
		
		JSONArray fichasArray = new JSONArray();
		int contador = 0;
		for (Ficha ficha : fichasHistorico) {
			JSONObject fichaObject = new JSONObject();
			fichaObject.put("login", ficha.getCliente().getLogin());
			fichaObject.put("numero", ficha.getNumero());
			fichaObject.put("hora", Data.converterHora(ficha.getData()));
			if(contador < 3){
				fichasArray.add(fichaObject);
				contador++;
			}
		}
		json.put("historico", fichasArray);
		
		JSONArray fichasArray2 = new JSONArray();
		for (Ficha ficha : fichasFila) {
			JSONObject fichaObject = new JSONObject();
			fichaObject.put("login", ficha.getCliente().getLogin());
			fichaObject.put("numero", ficha.getNumero());
			fichaObject.put("hora", Data.converterHora(ficha.getData()));
			fichasArray2.add(fichaObject);
		}
		json.put("fichas", fichasArray2);

		return json.toString();
	}
}
