package masterfila.util;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Validacao{

	private static Border bordaPadrao = new JTextField().getBorder();
	private static Color cor = new Color(255, 0, 0);
	private JTextField [] campos;

	public Validacao(JTextField [] campos){
		this.campos = campos;
	}

	public void setCampos(JTextField [] c){
		campos = c;
	}

	private static boolean cpfCompleto(String cpf){
		cpf = cpf.trim();
		if(cpf.length() == 14){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean cpfValido(String cpf){

		if(!cpfCompleto(cpf)){
			return false;
		}
		else{

			String cpfSize = cpf.trim();

			String subCpf = cpf.substring(0, 11).replace(".", "");

			if(cpf.replace(".", "").replace("-", "").trim().equals("")) {
				return true;
			}

			if(cpfSize.length() < 14) {
				return false;
			}

			if(subCpf.equals("111111111") || subCpf.equals("222222222") || subCpf.equals("333333333") || subCpf.equals("444444444")
					|| subCpf.equals("555555555") || subCpf.equals("666666666") || subCpf.equals("777777777") || subCpf.equals("888888888")
					|| subCpf.equals("999999999") || subCpf.equals("000000000")){
				return false;
			}
			else{

				int resto = auxiliarCpf(subCpf, 10) % 11;
				int primeiroDigito = 0;
				if(resto >= 2){
					primeiroDigito = 11 - resto;
				}

				subCpf = subCpf + primeiroDigito;

				resto = auxiliarCpf(subCpf, 11) % 11;
				int segundoDigito = 0;
				if(resto >= 2){
					segundoDigito = 11 - resto;
				}

				String resultado = primeiroDigito + "" + segundoDigito;
				return resultado.equals(cpf.substring(12, 14));
			}
		}
	}

	private static int auxiliarCpf(String subCpf, int valorInicial){

		int soma = 0;
		int digito;
		for(int i = valorInicial, j = 0; i >= 2; i--, j++){
			digito = Integer.parseInt(subCpf.charAt(j) + "");
			soma += (digito * i); 
		}
		return soma;
	}

	public static boolean cnpjValido(String cnpj){

		String cnpjSize = cnpj.trim();

		if(cnpjSize.length() < 18) {
			return false;
		}

		String subCnpj = cnpj.substring(0, 15).replace(".", "");
		subCnpj = subCnpj.replace("/", "");

		System.out.println(subCnpj);
		if(subCnpj.equals("000000000000")){
			return false;
		}

		int resto = auxiliarCnpj(subCnpj, 5) % 11;

		int primeiroDigito = 0;
		if(resto >= 2){
			primeiroDigito = 11 - resto;
		}

		subCnpj = subCnpj + primeiroDigito;

		resto = auxiliarCnpj(subCnpj, 6) % 11;

		int segundoDigito = 0;
		if(resto >= 2){
			segundoDigito = 11 - resto;
		}

		String resultado = primeiroDigito + "" + segundoDigito;
		return resultado.equals(cnpj.substring(16, 18));
	}

	private static int auxiliarCnpj(String subCnpj, int valorInicial){

		int soma = 0;
		int digito;
		boolean primeiroCiclo = true;
		for(int i = valorInicial, j = 0; i >= 2; i--, j++){
			digito = Integer.parseInt(subCnpj.charAt(j) + "");
			soma += (digito * i); 
			if(i == 2 && primeiroCiclo){
				i = 10;
				primeiroCiclo = false;
			}
		}
		return soma;
	}

	public static boolean emailValido(String email){
		if(!email.equals("")){
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");  
			Matcher m = p.matcher(email);  
			boolean emailValido = m.matches();  	  
			if (emailValido)  
				return true;
			else  
				return false;
		}
		else{
			return true;
		}
	}

	private void pintarBorda(JTextField campo){
		campo.setBorder(BorderFactory.createLineBorder(cor));
	}

	public boolean verificarCamposPreenchidos(){

		boolean preenchido = true;

		for(JTextField campo : campos){
			String sub = campo.getText().trim();
			sub = sub.replace(".", "");
			sub = sub.replace("-", "");
			sub = sub.replace("/", "");
			sub = sub.replace("(", "");
			sub = sub.replace(")", "");
			System.out.println(sub);
			if(sub.trim().equals("")){
				pintarBorda(campo);
				preenchido = false;
			}
		}
		return preenchido;
	}

	public void normalizarBordas(){
		for(JTextField campo : campos){
			campo.setBorder(bordaPadrao);
		}
	}
}
