package masterfila.util;

import java.util.List;

import javax.swing.JOptionPane;

import masterfila.entidade.Ficha;
import masterfila.entidade.Fila;
import masterfila.entidade.TipoFicha;
import masterfila.exception.FilaExistenteException;
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
			try {
				fachada.cadastroFila().cadastrar(nova);
			} catch (FilaExistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
}
