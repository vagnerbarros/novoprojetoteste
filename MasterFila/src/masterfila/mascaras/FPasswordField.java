package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;

public final class FPasswordField extends JPasswordField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FPasswordField(int QuantidadeMaxCaracteres) {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(QuantidadeMaxCaracteres));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		String caracteres=" qwertyuiopasdfghjkl�zxcvbnmQWERTYUIOPASDFGHJKL�ZXCVBNM��������������������������1234567890";
		if(!caracteres.contains(e.getKeyChar()+"")){
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
