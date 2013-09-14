package masterfila.mascaras;

public class FTratamentoDeCaracters {

	public static String removerCaracteresEspeciais(String txt){
		String[] caracters = {"/","\\",".","-","[","!","@","#","$","%","¨","&","*","(",")","_","+","=","§","ª","º","]","{","}"};
		for (int i = 0; i < caracters.length; i++) {
			txt = txt.replace(caracters[i], "");
		}
		return txt;
	}
	
	public static boolean verificarTeclasEdicaoTexto(int keyCode){
		if((keyCode<35) || (keyCode>40)){
			if((keyCode!=8) && (keyCode!=16) && (keyCode!=127)){
				return false;
			}
		}
		return true;
	}

}