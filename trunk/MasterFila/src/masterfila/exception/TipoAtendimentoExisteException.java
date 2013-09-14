package masterfila.exception;

public class TipoAtendimentoExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public TipoAtendimentoExisteException(){
		this.mensagem = "Este tipo de atendimento já existe.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
