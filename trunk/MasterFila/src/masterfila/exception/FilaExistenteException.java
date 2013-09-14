package masterfila.exception;

public class FilaExistenteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public FilaExistenteException(){
		this.mensagem = "Este tipo de fila já existe.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
