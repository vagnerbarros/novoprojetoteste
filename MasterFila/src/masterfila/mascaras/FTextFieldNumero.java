package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public final class FTextFieldNumero extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldNumero(int QuantidadeMaxCaracteres) {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(QuantidadeMaxCaracteres));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		String caracteres="0987654321";
		if(!caracteres.contains(e.getKeyChar()+"")){
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
