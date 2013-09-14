package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import masterfila.entidade.Guiche;
import masterfila.exception.NumeroGuicheExisteException;
import masterfila.fachada.Fachada;

public class DialogIncluirBox extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNomeBox;
	private JButton btnCancelar;
	private JButton btnIncluir;
	
	public DialogIncluirBox(){
		setTitle("Box de Atendimento - Incluir");
		setResizable(false);
		initComponents();
	}
	
	private void initComponents(){
		
		setModal(true);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 222);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		JLabel lblNomeDoBox = new JLabel("Número do Box:");
		//JLabel lblNomeDoBox = new JLabel("Nome do Box:");
		lblNomeDoBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNomeBox = new JTextField();
		txtNomeBox.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNomeDoBox)
					.addGap(18)
					.addComponent(txtNomeBox, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNomeDoBox))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(txtNomeBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
		);
		
		btnIncluir = new JButton("  Incluir");
		btnIncluir.addActionListener(this);
		btnIncluir.setIcon(new ImageIcon(DialogIncluirBox.class.getResource("/masterfila/desktop/view/img/ok.png")));
		
		btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(DialogIncluirBox.class.getResource("/masterfila/desktop/view/img/cancel.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogIncluirBox.class.getResource("/masterfila/desktop/view/img/icon_box_big.png")));
		
		JLabel lblBoxDeAtendimento = new JLabel("Incluir Box de Atendimento");
		lblBoxDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha os dados abaixo");
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblPreenchaOsDados, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBoxDeAtendimento, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblBoxDeAtendimento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPreenchaOsDados))
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
	
	private void cadastrar(){
		
		String box = txtNomeBox.getText();
		
		Guiche guiche = new Guiche();
		guiche.setNumero(box);
		
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastroGuiche().cadastrar(guiche);
			limparCampos();
			JOptionPane.showMessageDialog(this, "Box cadastrado com sucesso.");
		} catch (NumeroGuicheExisteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void limparCampos(){
		txtNomeBox.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnIncluir)){
			cadastrar();
		}
		else if(elemento.equals(btnCancelar)){
			this.dispose();
		}
	}
}
