package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public final class FTextFieldNomeProprio extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldNomeProprio(int quant) {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(quant));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		String caracteres=" qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNMÉéÚúÍíÓóÁáÊêÛûÎîÔôÂâÕõÃãÑñ";
		if(!caracteres.contains(e.getKeyChar()+"")){
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
