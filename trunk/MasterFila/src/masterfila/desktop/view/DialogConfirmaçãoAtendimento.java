package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import masterfila.entidade.Ficha;
import masterfila.entidade.Fila;
import masterfila.entidade.Guiche;
import masterfila.entidade.TipoFicha;
import masterfila.exception.FilaVaziaException;
import masterfila.fachada.Fachada;
import masterfila.util.GerenciadorArquivo;
import masterfila.util.Sessao;

public class DialogConfirmaçãoAtendimento extends JDialog implements ActionListener, WindowListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblTipoFicha;
	private JLabel lblSenha;
	private JLabel lblGuiche;
	private JButton btnRepetir;
	private JButton btnFinalizar;
	private JButton btnChamar;
	private Guiche guiche;
	private TipoFicha tipoFicha;
	private Fila fila;
	private Ficha ultimaFicha;
	private ViewChamadaSenha viewChamada;
	private GerenciadorArquivo gerenciador;
	
	public DialogConfirmaçãoAtendimento(Guiche guiche, TipoFicha tipoFicha){
		this.addWindowListener(this);
		setTitle("Atendimento");
		this.guiche = guiche;
		this.tipoFicha = tipoFicha;
		Fachada fachada = Fachada.getInstance();
		fila = fachada.cadastroFila().buscarFila(tipoFicha);
		setResizable(false);
		initComponents();
		try {
			viewChamada = new ViewChamadaSenha();
			gerenciador = new GerenciadorArquivo(tipoFicha.getNome());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initComponents(){

		setModal(true);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-400)/2, (screenSize.height-400)/2, 411, 346);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		JLabel lblNomeDoBox = new JLabel("N\u00FAmero do Box:");
		lblNomeDoBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		lblGuiche = new JLabel(guiche.getNumero());
		lblGuiche.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblTipoDeAtendimento = new JLabel("Tipo de Atendimento:");
		lblTipoDeAtendimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblTipoFicha = new JLabel(tipoFicha.getNome());
		lblTipoFicha.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lbl_senha = new JLabel("Senha:");
		lbl_senha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblSenha = new JLabel("");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_senha, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoFicha, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeDoBox)
						.addComponent(lblGuiche, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoDeAtendimento, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNomeDoBox)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblGuiche)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTipoDeAtendimento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTipoFicha, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl_senha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		btnFinalizar = new JButton("  Finalizar");
		btnFinalizar.addActionListener(this);
		btnFinalizar.setIcon(new ImageIcon(DialogConfirmaçãoAtendimento.class.getResource("/masterfila/desktop/view/img/cancel.png")));
		
		btnRepetir = new JButton("  Chamar Novamente");
		btnRepetir.addActionListener(this);
		btnRepetir.setIcon(new ImageIcon(DialogConfirmaçãoAtendimento.class.getResource("/masterfila/desktop/view/img/refresh.png")));
		
		btnChamar = new JButton("  Chamar");
		btnChamar.addActionListener(this);
		btnChamar.setIcon(new ImageIcon(DialogConfirmaçãoAtendimento.class.getResource("/masterfila/desktop/view/img/add.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnFinalizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRepetir, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChamar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRepetir, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnFinalizar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnChamar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogConfirmaçãoAtendimento.class.getResource("/masterfila/desktop/view/img/icon_atendimentoBig.png")));
		
		JLabel lblBoxDeAtendimento = new JLabel("Realizando Atendimento");
		lblBoxDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPreenchaOsDados = new JLabel("Realiza\u00E7\u00E3o de Atendimento");
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
	
	private void chamarProximo(){
		
		try {
			ultimaFicha = fila.atenderProximo();
			gerenciador.adicionar(ultimaFicha);
			ultimaFicha.setAtendente(Sessao.getFuncionario());
			ultimaFicha.setGuiche(guiche);
			Fachada fachada = Fachada.getInstance();
			fachada.cadastroFicha().fichaChamada(ultimaFicha);
			mostrarChamada();
		} catch (FilaVaziaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void mostrarChamada(){
		
		//chamada no terminal do atendente
		String senha = ultimaFicha.getNumero();
		String tipo = tipoFicha.getNome();
		lblSenha.setText(senha);
		lblTipoFicha.setText(tipo);
	}
	
	private void chamarHistorico(){
		//chamada no monitor do estabelecimento
		viewChamada.adicionarFicha(ultimaFicha);
		viewChamada.setVisible(true);
	}
	
	private void repetirChamada(){
		mostrarChamada();
	}
	
	private void liberarGuiche(){
		Fachada fachada = Fachada.getInstance();
		fachada.cadastroGuiche().abrirGuiche(guiche);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnFinalizar)){
			liberarGuiche();
			this.dispose();
			DialogRealizarAtendimento d = new DialogRealizarAtendimento();
			d.setVisible(true);
		}
		else if(elemento.equals(btnChamar)){
			chamarProximo();
			chamarHistorico();
		}
		else if(elemento.equals(btnRepetir)){
			repetirChamada();
		}
	}

	public void windowClosing(WindowEvent e) {
		liberarGuiche();
	}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
