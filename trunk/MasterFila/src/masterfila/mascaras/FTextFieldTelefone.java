package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public final class FTextFieldTelefone extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldTelefone() {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(13));
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
				++pos;
				this.setText("("+texto+")");
			}else if(tam<=7){
				System.out.println(pos);
				if((tam==7) && (pos>5 && pos<9)){
					++pos;
				}
				this.setText("("+texto.substring(0,2)+")"+texto.substring(2,tam));
			}else if(tam<=11){
				System.out.println(tam);
				if((tam==11) && (pos>5 && pos<9)){
					++pos;
				}
				this.setText("("+texto.substring(0,2)+")"+texto.substring(2,tam));
			}
			setCaretPosition(pos);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
