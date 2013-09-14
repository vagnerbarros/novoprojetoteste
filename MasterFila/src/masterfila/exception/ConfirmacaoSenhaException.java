package masterfila.exception;

public class ConfirmacaoSenhaException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public ConfirmacaoSenhaException(){
		this.mensagem = "Senha e Confirma��o de Senha n�o conferem.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
