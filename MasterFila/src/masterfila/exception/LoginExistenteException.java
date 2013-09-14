package masterfila.exception;

public class LoginExistenteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public LoginExistenteException(){
		this.mensagem = "Login já existe.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
