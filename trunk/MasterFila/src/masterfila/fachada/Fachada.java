package masterfila.fachada;

import masterfila.cadastro.CadastroEstabelecimento;
import masterfila.cadastro.CadastroFicha;
import masterfila.cadastro.CadastroFila;
import masterfila.cadastro.CadastroFuncionario;
import masterfila.cadastro.CadastroGuiche;
import masterfila.cadastro.CadastroTipoFicha;
import masterfila.cadastro.CadastroUsuario;
import masterfila.repositorio.RepositorioEstabelecimento;
import masterfila.repositorio.RepositorioFicha;
import masterfila.repositorio.RepositorioFila;
import masterfila.repositorio.RepositorioFuncionario;
import masterfila.repositorio.RepositorioGuiche;
import masterfila.repositorio.RepositorioTipoFicha;
import masterfila.repositorio.RepositorioUsuario;

public class Fachada {

	private static Fachada instancia;
	private CadastroFuncionario cadFuncionario;
	private CadastroUsuario cadUsuario;
	private CadastroFicha cadFicha;
	private CadastroEstabelecimento cadEstabelecimento;
	private CadastroTipoFicha cadTipoFicha;
	private CadastroGuiche cadGuiche;
	private CadastroFila cadFila;
	
	private Fachada(){
		inicializar();
	}
	
	private void inicializar(){
		
		RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
		cadFuncionario = new CadastroFuncionario(repFuncionario);
		
		RepositorioUsuario repUsuario = new RepositorioUsuario();
		cadUsuario = new CadastroUsuario(repUsuario);
		
		RepositorioFicha repFicha = new RepositorioFicha();
		cadFicha = new CadastroFicha(repFicha);
		
		RepositorioEstabelecimento repEmpresa = new RepositorioEstabelecimento();
		cadEstabelecimento = new CadastroEstabelecimento(repEmpresa);
		
		RepositorioGuiche repGuiche = new RepositorioGuiche();
		cadGuiche = new CadastroGuiche(repGuiche);
		
		RepositorioTipoFicha repTipoFicha = new RepositorioTipoFicha();
		cadTipoFicha = new CadastroTipoFicha(repTipoFicha);
		
		RepositorioFila repFila = new RepositorioFila();
		cadFila = new CadastroFila(repFila);
	}
	
	public static Fachada getInstance(){
		
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public CadastroFuncionario cadastroFuncionario(){
		return cadFuncionario;
	}
	
	public CadastroUsuario cadastroUsuario(){
		return cadUsuario;
	}
	
	public CadastroFicha cadastroFicha(){
		return cadFicha;
	}
	
	public CadastroEstabelecimento cadastroEmpresa(){
		return cadEstabelecimento;
	}
	
	public CadastroTipoFicha cadastroTipoFicha(){
		return cadTipoFicha;
	}
	
	public CadastroGuiche cadastroGuiche(){
		return cadGuiche;
	}
	
	public CadastroFila cadastroFila(){
		return cadFila;
	}
}