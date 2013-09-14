package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public final class FTextFieldOrgaoExpedidor extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldOrgaoExpedidor() {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(10));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		String caracteres="";
		
		if(this.getText().contains("/")){
			caracteres=" qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM";
		}else{
			caracteres=" qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM/";
		}
		
		if(!caracteres.contains(e.getKeyChar()+"")){
			e.consume();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int pos = getCaretPosition();
		this.setText(this.getText().toUpperCase());
		setCaretPosition(pos);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
