package masterfila.desktop;

import java.io.IOException;

import javax.swing.JOptionPane;

import masterfila.desktop.view.DialogSolicitarFicha;
import masterfila.util.CarregarDados;

public class LauncherSolicitarFicha {

	public static void main(String[] args) throws IOException {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

		CarregarDados.go();
		
		DialogSolicitarFicha d = new DialogSolicitarFicha();
		d.setVisible(true);
	}
}
