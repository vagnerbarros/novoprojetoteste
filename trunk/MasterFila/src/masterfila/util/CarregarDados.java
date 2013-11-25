package masterfila.util;

import java.util.List;

import masterfila.entidade.Ficha;
import masterfila.entidade.Fila;
import masterfila.entidade.TipoFicha;
import masterfila.fachada.Fachada;

public class CarregarDados {

	public static void go(){
		//carregando as filas na memória
		Fachada fachada = Fachada.getInstance();
		List<TipoFicha> tipos = fachada.cadastroTipoFicha().listar();
		for(TipoFicha tipo : tipos){
			Fila nova = new Fila(tipo);
			List<Ficha> fichas = fachada.cadastroFicha().listarTipoAbertas(tipo);
			nova.setFichas(fichas);
			fachada.cadastroFila().cadastrar(nova);
		}
	}
}
