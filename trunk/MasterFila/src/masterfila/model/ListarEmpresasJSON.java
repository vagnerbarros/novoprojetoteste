package masterfila.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.dominio.Categoria;
import masterfila.entidade.Estabelecimento;
import masterfila.fachada.Fachada;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListarEmpresasJSON implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		Fachada fachada = Fachada.getInstance();
		List<Estabelecimento> empresas = fachada.cadastroEmpresa().listarCategoria(Categoria.AGENCIA);
		String json = gerarEmpresasJSON(empresas);
		PrintWriter print;
		try {
			print = response.getWriter();
			print.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private String gerarEmpresasJSON(List<Estabelecimento> listaEmpresas) {
		JSONObject json = new JSONObject();
		JSONArray empresasArray = new JSONArray();
		for (Estabelecimento empresa : listaEmpresas) {
			JSONObject empresaObject = new JSONObject();
			empresaObject.put("nome", empresa.getNome());
			
			empresasArray.add(empresaObject);
		}
		
		json.put("empresas", empresasArray);
		
		return json.toString();
	}

}
