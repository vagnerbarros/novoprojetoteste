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
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import masterfila.dominio.SituacaoGuiche;
import masterfila.entidade.Guiche;
import masterfila.fachada.Fachada;
import masterfila.util.Tabela;

public class DialogListagemBox extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton btnRemover;
	private Tabela<Guiche> tabela;
	
	public DialogListagemBox(){
		setTitle("Boxes de Atendimento - Listagem");
		setResizable(false);
		initComponents();
	}
	
	private void initComponents(){
		
		setModal(true);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-599)/2, (screenSize.height-500)/2, 599, 418);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		tabela = new Tabela<Guiche>(new String [] {"N�mero", "Situa��o"});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.montarTabela(Fachada.getInstance().cadastroGuiche().listar());
		scrollPane.setViewportView(tabela);
		
		btnRemover = new JButton("  Remover");
		btnRemover.addActionListener(this);
		btnRemover.setIcon(new ImageIcon(DialogListagemBox.class.getResource("/masterfila/desktop/view/img/cancel.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(471, Short.MAX_VALUE)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogListagemBox.class.getResource("/masterfila/desktop/view/img/icon_box_big.png")));
		
		JLabel lblBoxDeAtendimento = new JLabel("Boxes de Atendimento");
		lblBoxDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPreenchaOsDados = new JLabel("Abaixo voc\u00EA observa os boxes de atendimento cadastrados");
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBoxDeAtendimento, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblPreenchaOsDados, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
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
	
	private void remover(){
		int linha = tabela.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Guiche guiche = (Guiche) tabela.getModel().getValueAt(linha, 0);
				
				if(guiche.getSituacao().equals(SituacaoGuiche.FUNCIONANDO)){
					JOptionPane.showMessageDialog(this, "O Guiche est� em atendimento");
				}
				else{
				Fachada fachada = Fachada.getInstance();
				fachada.cadastroGuiche().remover(guiche);
				tabela.montarTabela(fachada.cadastroGuiche().listar());
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Selecione o box para remover.");
		}
	}

	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnRemover)){
			remover();
		}
	}
}
