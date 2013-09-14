package masterfila.exception;

public class FichaInvalidaException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public FichaInvalidaException(){
		this.mensagem = "Ficha inv�lida.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
