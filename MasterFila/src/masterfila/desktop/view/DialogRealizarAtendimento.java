package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import masterfila.entidade.Guiche;
import masterfila.entidade.TipoFicha;
import masterfila.fachada.Fachada;

public class DialogRealizarAtendimento extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnCancelar;
	private JButton btnChamar;
	private JComboBox<Guiche> comboGuiche;
	private JComboBox<TipoFicha> comboTipoFicha;
	
	public DialogRealizarAtendimento(){
		setTitle("Atendimento");
		setResizable(false);
		initComponents();
	}
	
	private void initComponents(){
		
		setModal(true);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-400)/2, (screenSize.height-400)/2, 400, 258);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		JLabel lblNomeDoBox = new JLabel("Atender no box:");
		lblNomeDoBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		comboGuiche = new JComboBox<Guiche>();
		comboTipoFicha = new JComboBox<TipoFicha>();
		iniciarCombos();
		
		JLabel lblTipoDeAtendimento = new JLabel("Tipo de Atendimento:");
		lblTipoDeAtendimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipoDeAtendimento)
						.addComponent(lblNomeDoBox))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboGuiche, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboTipoFicha, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(lblTipoDeAtendimento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboGuiche, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeDoBox))
							.addGap(11)
							.addComponent(comboTipoFicha, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnChamar = new JButton("  Iniciar Atendimento");
		btnChamar.addActionListener(this);
		btnChamar.setIcon(new ImageIcon(DialogRealizarAtendimento.class.getResource("/masterfila/desktop/view/img/ok.png")));
		
		btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(DialogRealizarAtendimento.class.getResource("/masterfila/desktop/view/img/cancel.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(129, Short.MAX_VALUE)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChamar)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChamar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogRealizarAtendimento.class.getResource("/masterfila/desktop/view/img/icon_atendimentoBig.png")));
		
		JLabel lblBoxDeAtendimento = new JLabel("Realizar Atendimento");
		lblBoxDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPreenchaOsDados = new JLabel("Selecione as op\u00E7\u00F5es abaixo");
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
	
	private void iniciarCombos(){
		Fachada fachada = Fachada.getInstance();
		List<Guiche> guichesDisponiveis = fachada.cadastroGuiche().listarDisponiveis();
		List<TipoFicha> tiposFicha = fachada.cadastroTipoFicha().listar();
		
		//iniciando combo guiche
		for(Guiche g : guichesDisponiveis){
			comboGuiche.addItem(g);
		}
		
		//iniciando combo Tipos de ficha
		for(TipoFicha t : tiposFicha){
			comboTipoFicha.addItem(t);
		}
	}
	
	private void iniciarAtendimento(){
		
		Guiche guiche = (Guiche) comboGuiche.getSelectedItem();
		TipoFicha tipoFicha = (TipoFicha) comboTipoFicha.getSelectedItem();
		
		Fachada fachada = Fachada.getInstance();
		
		fachada.cadastroGuiche().fecharGuiche(guiche);
		DialogConfirmacaoAtendimento d = new DialogConfirmacaoAtendimento(guiche, tipoFicha);
		this.dispose();
		d.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnChamar)){
			iniciarAtendimento();
		}
		if(elemento.equals(btnCancelar)){
			this.dispose();
		}
	}
}
