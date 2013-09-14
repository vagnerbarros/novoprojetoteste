package masterfila.exception;

public class NumeroGuicheExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public NumeroGuicheExisteException(){
		this.mensagem = "Número de Guiche já existe.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
