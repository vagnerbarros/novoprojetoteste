package masterfila.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String getDataAtual(){
		      
		Date dataAtual = new Date();   
		String data = fmt.format(dataAtual);
		return data;
	}
	
	public static Date converterData(String data){
		try {
			return fmt.parse(data);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static boolean isDataAtualEntre(String data1, String data2){
		Date data_inicio = converterData(data1);
		Date data_fim = converterData(data2);
		Date data_atual = converterData(getDataAtual());
		if(data_atual.compareTo(data_inicio) == 0 || (data_inicio.before(data_atual) && data_fim.after(data_atual)) || (data_atual.compareTo(data_fim) == 0)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean isDataAtualAntes(String d){
		Date data_atual = converterData(getDataAtual());
		Date data = converterData(d);
		if(data_atual.before(data)){
			return true;
		}
		else{
			return false;
		}
	}
}
