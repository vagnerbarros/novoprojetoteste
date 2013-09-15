package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import masterfila.entidade.Ficha;
import masterfila.util.Data;

public class DialogFicha extends JDialog{

	private static final long serialVersionUID = 1L;
	private Ficha ficha;
	
	public DialogFicha(Ficha ficha){
		setTitle("Solicitar");
		setResizable(false);
		this.ficha = ficha;
		initComponents();
	}
	
	private void initComponents(){
		
		setModal(true);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-400)/2, (screenSize.height-400)/2, 295, 310);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		JLabel lblEstabelecimento = new JLabel("Estabelecimento:");
		lblEstabelecimento.setBounds(10, 11, 211, 15);
		lblEstabelecimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblEstabelecimento);
		
		JLabel LBL_ESTABELECIMENTO = new JLabel(ficha.getCliente().getEmpresa().getNome());
		LBL_ESTABELECIMENTO.setForeground(new Color(0, 153, 0));
		LBL_ESTABELECIMENTO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LBL_ESTABELECIMENTO.setBounds(63, 37, 175, 15);
		panel_1.add(LBL_ESTABELECIMENTO);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Tipo de Atendimento:");
		label.setBounds(10, 11, 169, 15);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label);
		
		JLabel LBL_TIPO = new JLabel(ficha.getTipo().getNome());
		LBL_TIPO.setForeground(new Color(0, 153, 0));
		LBL_TIPO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LBL_TIPO.setBounds(61, 35, 118, 15);
		panel_2.add(LBL_TIPO);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(10, 61, 64, 15);
		panel_2.add(lblSenha);
		
		JLabel LBL_SENHA = new JLabel(ficha.getNumero());
		LBL_SENHA.setForeground(new Color(0, 153, 0));
		LBL_SENHA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LBL_SENHA.setBounds(61, 87, 118, 15);
		panel_2.add(LBL_SENHA);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogFicha.class.getResource("/masterfila/desktop/view/img/icon_atendimentoBig.png")));
		
		JLabel lblBoxDeAtendimento = new JLabel(ficha.getCliente().getNome());
		lblBoxDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPreenchaOsDados = new JLabel(Data.converterData(ficha.getData()) + "  " + Data.converterHora(ficha.getData()));
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBoxDeAtendimento, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblPreenchaOsDados, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
}
