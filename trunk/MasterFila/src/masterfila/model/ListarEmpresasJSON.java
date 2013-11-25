package masterfila.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterfila.dominio.Categoria;
import masterfila.dominio.Cidades;
import masterfila.entidade.Estabelecimento;
import masterfila.fachada.Fachada;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListarEmpresasJSON implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {

		Fachada fachada = Fachada.getInstance();
		List<Estabelecimento> empresas = null;
		String categoria = request.getParameter("categoria");
		String cidade = request.getParameter("cidade");
		if(categoria != null){
			if(categoria.equals("1")){
				categoria = Categoria.CONSULTORIO;
			}else if(categoria.equals("2")){
				categoria = Categoria.REPARTICAO;
			}else if(categoria.equals("3")){
				categoria = Categoria.AGENCIA;
			}else if(categoria.equals("4")){
				categoria = Categoria.CARTORIO;
			}else if(categoria.equals("5")){
				categoria = Categoria.PREFEITURA;
			}
		}
		if(cidade != null){
			if(cidade.equals("1")){
				cidade = Cidades.CARUARU;
			}else if(cidade.equals("2")){
				cidade = Cidades.TORITAMA;
			}else if(cidade.equals("3")){
				cidade = Cidades.RECIFE;
			}else if(cidade.equals("4")){
				cidade = Cidades.SANTA_CRUZ;
			}
		}
		empresas = fachada.cadastroEmpresa().listarCidadeCategoria(cidade, categoria);

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
			empresaObject.put("id", empresa.getId() + "");
			empresaObject.put("nome", empresa.getNome());
			empresasArray.add(empresaObject);
		}

		json.put("empresas", empresasArray);

		return json.toString();
	}
}
