package masterfila.exception;

public class CpfExistenteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public CpfExistenteException(){
		this.mensagem = "CPF j� existe.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
