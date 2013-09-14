package masterfila.exception;

public class NumeroGuicheExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public NumeroGuicheExisteException(){
		this.mensagem = "N�mero de Guiche j� existe.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
