package masterfila.cadastro;

import java.util.List;

import masterfila.entidade.Estabelecimento;
import masterfila.repositorio.RepositorioEstabelecimento;

public class CadastroEstabelecimento {

	private RepositorioEstabelecimento rep;
	
	public CadastroEstabelecimento(RepositorioEstabelecimento rep){
		this.rep = rep;
	}
	
	public void cadastrar(Estabelecimento novo){
		rep.inserir(novo);
	}
	
	public void atualizar(Estabelecimento atual){
		rep.atualizar(atual);
	}
	
	public void remover(Estabelecimento deletado){
		rep.remover(deletado);
	}
	
	public List<Estabelecimento> listar(){
		return rep.listar();
	}
	
	public List<Estabelecimento> listarTodas(){
		return rep.listarTodas();
	}

	public List<Estabelecimento> listarCategoria(String categoria) {
		return rep.listarCategoria(categoria);
	}
	
	public List<Estabelecimento> listarCidade(String cidade) {
		return rep.listarCidade(cidade);
	}
	
	public List<Estabelecimento> listarCidadeCategoria(String cidade, String categoria) {
		return rep.listarCidadeCategoria(cidade, categoria);
	}
	
	public Estabelecimento buscarId(long id){
		return rep.buscarPorId(id);
	}

	public void ativar(Estabelecimento estab) {
		rep.ativar(estab);
	}
}
