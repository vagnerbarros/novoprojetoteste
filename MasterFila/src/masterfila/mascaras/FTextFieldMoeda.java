package masterfila.mascaras;

/*
 * Autor: Plínio Manoel Oliveira Silva
 * email: ti.plinio@gmail.com
 * 28/05/2013
 * 
 * */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public final class FTextFieldMoeda extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	private String texto = "";
	
	public FTextFieldMoeda() {
		this.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		String caracteres="0987654321";
		if(!caracteres.contains(e.getKeyChar()+"")){
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int posVirgula = 0;
		
		if(e.getKeyCode()!=8 && e.getKeyCode()!=37 && e.getKeyCode()!=38 && e.getKeyCode()!=39 && e.getKeyCode()!=40){
			
			texto = this.getText().replace(",", "");
			
			int tam = texto.length();
			
			if(texto.substring(0,1).equals("0")){
				texto = texto.substring(1,tam);
				tam--;
			}
			
			if(tam==1){
				
				posVirgula = 0;
				
				this.setText(texto.substring(0,posVirgula)+"0,"+texto.substring(posVirgula,tam));
					
			}else if(tam==2){
				
				posVirgula = 0;
				
				this.setText(texto.substring(0,posVirgula)+"0,"+texto.substring(posVirgula,tam));
				
				
			}else if(tam>2){

				posVirgula = tam-2;
				
				if( tam==3 && texto.substring(0,posVirgula).equals("0") ){
					System.out.println("Zero");
					this.setText(texto.substring(0,posVirgula)+","+texto.substring(posVirgula,tam));
				}else
				
				if(texto.substring(0,posVirgula).equals("0")){
					this.setText(texto.substring(1,posVirgula)+","+texto.substring(posVirgula,tam));
				}else if(texto.substring(0,posVirgula).equals("0") && texto.substring(1,posVirgula).equals("0") ){
					this.setText(texto.substring(1,posVirgula)+","+texto.substring(posVirgula,tam));
				}else{
					this.setText(texto.substring(0,posVirgula)+","+texto.substring(posVirgula,tam));
				}
				
			}
			
			
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
}
