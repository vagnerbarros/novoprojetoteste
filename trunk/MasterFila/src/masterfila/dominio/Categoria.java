package masterfila.dominio;

public class Categoria {

	public static String CONSULTORIO = "Consultório Médico";
	public static String REPARTICAO = "Repartição Pública";
	public static String AGENCIA = "Agência Bancária";
	public static String CARTORIO = "Cartório";
	public static String PREFEITURA = "Prefeitura e setores vinculados";
	public static String OUTRO = "Outros";
	
	public static String[] getCategorias(){
		String [] retorno = {CONSULTORIO, REPARTICAO, AGENCIA, CARTORIO, PREFEITURA, OUTRO};
		return retorno;
	}
}
