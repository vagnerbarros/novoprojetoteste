package masterfila.repositorio;

import java.util.ArrayList;
import java.util.List;

import masterfila.dao.Dao;
import masterfila.dominio.Chamado;
import masterfila.entidade.Ficha;
import masterfila.entidade.TipoFicha;
import masterfila.util.Constants;

public class RepositorioFicha {

	private Dao dao;
	
	public RepositorioFicha(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Ficha novo){
		novo.setStatus(Constants.ATIVO);
		novo.setChamado(Chamado.NAO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Ficha atual){
		dao.atualizarObjeto(atual);
	}
	
	public List<Ficha> listar(){
		return (List<Ficha>) dao.criarQuery("FROM ficha WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	public void remover(Ficha del){
		del.setStatus(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}

	public List<Ficha> listarTipoAberta(TipoFicha tipo) {
		List<Ficha> lista = (List<Ficha>)dao.buscarPorChaveEstrangeira(Ficha.class, tipo, "tipo");
		List<Ficha> retorno = new ArrayList<Ficha>();
		for(Ficha f : lista){
			if(f.getChamado().equals(Chamado.NAO)){
				retorno.add(f);
			}
		}
		return retorno;
	}
}
