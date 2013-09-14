package masterfila.util;

import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Funcionario;

public abstract class Sessao {

	private static Estabelecimento empresa;
	private static Funcionario funcionario;
	
	public static Estabelecimento getEmpresa(){
		return empresa;
	}
	
	public static void setEmpresa(Estabelecimento emp){
		empresa = emp;
	}
	
	public static Funcionario getFuncionario(){
		return funcionario;
	}
	
	public static void setFuncionario(Funcionario f){
		funcionario = f;
	}
	
	public static void deslogar(){
		funcionario = null;
		empresa = null;
	}
}
