package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public final class FTextFieldCep extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldCep(int QuantidadeMaxCaracteres) {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(QuantidadeMaxCaracteres));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(FTratamentoDeCaracters.verificarTeclasEdicaoTexto(e.getKeyCode())==false){
			String caracteres="1234567890";
			if(!caracteres.contains(e.getKeyChar()+"")){
					e.consume();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(FTratamentoDeCaracters.verificarTeclasEdicaoTexto(e.getKeyCode())==false){
			int pos = getCaretPosition();
			String texto = FTratamentoDeCaracters.removerCaracteresEspeciais(this.getText());
			int tam = FTratamentoDeCaracters.removerCaracteresEspeciais(this.getText()).length();
			if(tam<=2){
				if(tam==2){
					++pos;
				}
				this.setText(texto+".");
			}else if(tam<=5){
				if(tam==7 && pos>2){
					++pos;
				}
				this.setText(texto.substring(0,2)+"."+texto.substring(2,tam)+"-");
			}else if(tam<=8){
				if(tam==6 && pos>5){
					++pos;
				}
				this.setText(texto.substring(0,2)+"."+texto.substring(2,5)+"-"+texto.substring(5,tam));
			}
			setCaretPosition(pos);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
