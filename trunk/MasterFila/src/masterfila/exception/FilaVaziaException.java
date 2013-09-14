package masterfila.exception;

public class FilaVaziaException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public FilaVaziaException(){
		this.mensagem = "Nenhuma ficha na fila.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
