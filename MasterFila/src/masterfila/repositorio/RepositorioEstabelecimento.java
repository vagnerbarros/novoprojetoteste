package masterfila.repositorio;

import java.util.List;

import masterfila.dao.Dao;
import masterfila.entidade.Estabelecimento;
import masterfila.util.Constants;

public class RepositorioEstabelecimento {

	private Dao dao;

	public RepositorioEstabelecimento(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}

	public void inserir(Estabelecimento novo){
		novo.setStatus(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}

	public void atualizar(Estabelecimento atual){
		dao.atualizarObjeto(atual);
	}

	public List<Estabelecimento> listar(){
		return (List<Estabelecimento>) dao.criarQuery("FROM estabelecimento WHERE status <> '" + Constants.INATIVO + "'");
	}

	public void remover(Estabelecimento del){
		Estabelecimento e = buscarPorId(del.getId());
		if(e != null){			
			e.setStatus(Constants.INATIVO);
			dao.atualizarObjeto(e);
		}
	}

	public Estabelecimento buscarPorId(long id){
		List<Estabelecimento> lista = (List<Estabelecimento>) dao.criarQuery("FROM estabelecimento WHERE id = " + id + " AND status <> '" + Constants.INATIVO + "'");
		if(lista != null){
			return lista.get(0);
		}
		else{
			return null;
		} 
	}

	public List<Estabelecimento> listarCategoria(String categoria) {
		return (List<Estabelecimento>) dao.buscarPorLike("categoria", categoria, Estabelecimento.class);
	}

	public List<Estabelecimento> listarCidade(String cidade) {
		return (List<Estabelecimento>) dao.buscarPorLike("cidade", cidade, Estabelecimento.class);
	}

	public List<Estabelecimento> listarCidadeCategoria(String cidade, String categoria) {
		return (List<Estabelecimento>) dao.buscarPorLikeIlimitado(new String [] {"cidade", "categoria"}, new String [] {cidade, categoria}, Estabelecimento.class);
	}

	public List<Estabelecimento> listarTodas() {
		return (List<Estabelecimento>) dao.criarQuery("FROM estabelecimento");
	}

	public void ativar(Estabelecimento estab) {
		Estabelecimento e = buscarIdInativo(estab.getId());
		if(e != null){			
			e.setStatus(Constants.ATIVO);
			dao.atualizarObjeto(e);
		}
	}

	private Estabelecimento buscarIdInativo(long id){
		List<Estabelecimento> lista = (List<Estabelecimento>) dao.criarQuery("FROM estabelecimento WHERE id = " + id + " AND status <> '" + Constants.ATIVO + "'");
		if(lista != null){
			return lista.get(0);
		}
		else{
			return null;
		} 
	}
}
