package masterfila.mascaras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public final class FTextFieldEmail extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	public FTextFieldEmail(int QuantidadeMaxCaracteres) {
		this.addKeyListener(this);
		this.setDocument(new QuantidadeFixaCaracteres(QuantidadeMaxCaracteres));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		String caracteres="";
		
		if(this.getText().contains("@")){
			caracteres="QWERTYUIOPASDFGHJKLÇZXCVBNMÉéÚúÍíÓóÁáÊêÛûÎîÔôÂâÕõÃãÑñ;:/@";
		}else{
			caracteres="QWERTYUIOPASDFGHJKLÇZXCVBNMÉéÚúÍíÓóÁáÊêÛûÎîÔôÂâÕõÃãÑñ;:/";
		}
		
		if(caracteres.contains(e.getKeyChar()+"")){
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
