package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public final class FTextFieldPlacaVeiculo extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldPlacaVeiculo() {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(8));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		int tam = FTratamentoDeCaracters.removerCaracteresEspeciais(this.getText()).length();
		if(tam<3){
			String caracteres="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
			if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
			}
		}else if(tam==3){
			String caracteres="1234567890";
			if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
			}else{
				this.setText(this.getText().substring(0,3)+"-");
			}
		}else if(tam>3){
			String caracteres="1234567890";
			if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {}
	
}
