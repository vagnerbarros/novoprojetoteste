package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public final class FTextFieldCpf extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldCpf() {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(14));
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
			if(tam<=3){
				if(tam==3){
					++pos;
				}
				this.setText(texto+".");
			}else if(tam<=6){
				if(tam==6 && pos>3){
					++pos;
				}
				this.setText(texto.substring(0,3)+"."+texto.substring(3,tam)+".");
			}else if(tam<=9){
				if(tam==9 && pos>6){
					++pos;
				}
				this.setText(texto.substring(0,3)+"."+texto.substring(3,6)+"."+texto.substring(6,tam)+"-");
			}else if(tam<=11){
				this.setText(texto.substring(0,3)+"."+texto.substring(3,6)+"."+texto.substring(6,9)+"-"+texto.substring(9,tam));
			}
			setCaretPosition(pos);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
