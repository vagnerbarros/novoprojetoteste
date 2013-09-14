package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import masterfila.entidade.Funcionario;
import masterfila.exception.LoginSenhaIncorretosException;
import masterfila.fachada.Fachada;
import masterfila.util.Sessao;

public class DialogLogin extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JButton btCancelar;
	private JButton btConfirmar;
	private JPasswordField txtSenha;

	public DialogLogin(){
		setTitle("Login");
		setResizable(false);
		initComponents();
	}

	private void initComponents(){

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 356, 291);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);

		JLabel lblNomeDoBox = new JLabel("Login:");
		lblNomeDoBox.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(this);
		txtSenha.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeDoBox)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(73, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomeDoBox)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		btConfirmar = new JButton("  Confirmar");
		btConfirmar.addActionListener(this);
		btConfirmar.setIcon(new ImageIcon(DialogLogin.class.getResource("/masterfila/desktop/view/img/ok.png")));

		btCancelar = new JButton("  Cancelar");
		btCancelar.addActionListener(this);
		btCancelar.setIcon(new ImageIcon(DialogLogin.class.getResource("/masterfila/desktop/view/img/cancel.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
						.addContainerGap(138, Short.MAX_VALUE)
						.addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btConfirmar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
						.addContainerGap(14, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btConfirmar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogLogin.class.getResource("/masterfila/desktop/view/img/login.png")));

		JLabel lblBoxDeAtendimento = new JLabel("Realize seu Login");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btConfirmar)){
			logar();
		}
		else if(elemento.equals(btCancelar)){
			dispose();
		}
	}

	private void logar(){

		if(!camposPreenchidos()){
			JOptionPane.showMessageDialog(this, "Os campos de Login e Senha são obrigatórios");
		}
		else{
			String login = txtLogin.getText();

			@SuppressWarnings("deprecation")
			String senha = txtSenha.getText();

			Fachada fachada = Fachada.getInstance();
			try {
				Funcionario logado = fachada.cadastroFuncionario().logar(login, senha);
				Sessao.setFuncionario(logado);
				Sessao.setEmpresa(logado.getEmpresa());
				ViewPrincipal v = new ViewPrincipal();
				v.setVisible(true);
				this.dispose();	
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (LoginSenhaIncorretosException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	@SuppressWarnings("deprecation")
	private boolean camposPreenchidos() {
		
		boolean retorno = false;
		if(!txtLogin.getText().equals("") && !txtSenha.getText().equals("")){
			retorno = true;
		}
		return retorno;
	}

	public void keyReleased(KeyEvent e) {

		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(txtSenha)){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				logar();
			}
		}
	}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
}
