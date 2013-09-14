package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import masterfila.entidade.Ficha;

public class ViewChamadaSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblSENHA;
	private JLabel lbl_BOX;
	private JLabel lbl_ATENDIMENTO;
	private JLabel lbl_historico_senha_1;
	private JLabel lbl_historico_senha_2;
	private JLabel lbl_historico_senha_3;
	private JLabel lbl_historico_box_1;
	private JLabel lbl_historico_box_2;
	private JLabel lbl_historico_box_3;
	private List<Ficha> historico;
	private int index;

	public ViewChamadaSenha() throws IOException{
		getContentPane().setBackground(SystemColor.controlHighlight);
		initComponents();
		historico = new ArrayList<Ficha>();
		index = 0;
	}
	
	private static BufferedImage loadImage(URL url) throws IOException {
		return ImageIO.read(url);
	}	
	
	private void initComponents() throws IOException{
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 889, 555);
		
		JImagePanel panel = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_master.png")));
		
		panel.setBackground(new Color(4, 125, 181));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
					.addGap(10))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
					.addGap(12))
		);
		
		JImagePanel panel_3 = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_master.png")));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JImagePanel panel_4 = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_master.png")));
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBox = new JLabel("BOX");
		lblBox.setForeground(Color.WHITE);
		lblBox.setBackground(Color.WHITE);
		lblBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblBox.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_4.add(lblBox);
		
		JImagePanel panel_5 = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_chamada.png")));
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JImagePanel panel_6 = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_chamada.png")));
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
								.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_BOX = new JLabel("-");
		lbl_BOX.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BOX.setForeground(Color.BLACK);
		lbl_BOX.setFont(new Font("Tahoma", Font.BOLD, 70));
		panel_6.add(lbl_BOX);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblSENHA = new JLabel("-");
		lblSENHA.setHorizontalAlignment(SwingConstants.CENTER);
		lblSENHA.setForeground(Color.BLACK);
		lblSENHA.setFont(new Font("Tahoma", Font.BOLD, 70));
		panel_5.add(lblSENHA);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_ATENDIMENTO = new JLabel("-");
		lbl_ATENDIMENTO.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ATENDIMENTO.setForeground(Color.BLACK);
		lbl_ATENDIMENTO.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_7.add(lbl_ATENDIMENTO);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_3.add(lblSenha);
		panel_1.setLayout(gl_panel_1);
		
		JImagePanel panel_8 = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_master.png")));
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_9 =  new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_master.png")));
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_10 =  new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg_master.png")));
		panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_17, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(panel_8, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(panel_11, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(panel_16, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(15)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(panel_16, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_17, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_historico_box_3 = new JLabel("-");
		lbl_historico_box_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historico_box_3.setForeground(Color.BLACK);
		lbl_historico_box_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_historico_box_3.setBackground(Color.BLACK);
		panel_16.add(lbl_historico_box_3);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_historico_senha_3 = new JLabel("-");
		lbl_historico_senha_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historico_senha_3.setForeground(Color.BLACK);
		lbl_historico_senha_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_historico_senha_3.setBackground(Color.BLACK);
		panel_15.add(lbl_historico_senha_3);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_historico_box_2 = new JLabel("-");
		lbl_historico_box_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historico_box_2.setForeground(Color.BLACK);
		lbl_historico_box_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_historico_box_2.setBackground(Color.BLACK);
		panel_14.add(lbl_historico_box_2);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_historico_senha_2 = new JLabel("-");
		lbl_historico_senha_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historico_senha_2.setForeground(Color.BLACK);
		lbl_historico_senha_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_historico_senha_2.setBackground(Color.BLACK);
		panel_13.add(lbl_historico_senha_2);
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_historico_box_1 = new JLabel("-");
		lbl_historico_box_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historico_box_1.setForeground(Color.BLACK);
		lbl_historico_box_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_historico_box_1.setBackground(Color.BLACK);
		panel_12.add(lbl_historico_box_1);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbl_historico_senha_1 = new JLabel("-");
		lbl_historico_senha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historico_senha_1.setForeground(Color.BLACK);
		lbl_historico_senha_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_historico_senha_1.setBackground(Color.BLACK);
		panel_11.add(lbl_historico_senha_1);
		panel_10.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblBox_1 = new JLabel("BOX");
		lblBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBox_1.setForeground(Color.WHITE);
		lblBox_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBox_1.setBackground(Color.BLACK);
		panel_10.add(lblBox_1);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSenha_1 = new JLabel("SENHA");
		lblSenha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha_1.setForeground(Color.WHITE);
		lblSenha_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSenha_1.setBackground(Color.BLACK);
		panel_9.add(lblSenha_1);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblHistrico = new JLabel("HIST\u00D3RICO");
		lblHistrico.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistrico.setForeground(Color.WHITE);
		lblHistrico.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_8.add(lblHistrico);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
	}
	
	public void adicionarFicha(Ficha ficha){
		
		historico.add(index, ficha);
		index++;
		atualizarTela();
	}
	
	private void atualizarTela(){
		
		Ficha atual = historico.get(index - 1);
		lblSENHA.setText(atual.getNumero());
		lbl_BOX.setText(atual.getGuiche().getNumero());
		lbl_ATENDIMENTO.setText(atual.getTipo().getNome());

		atualizarHistorico();
	}
	
	private void atualizarHistorico(){
		
		Ficha atual = null;
		int posicao = index - 1;
		if(posicao >= 0){
			atual = historico.get(posicao);
			lbl_historico_senha_1.setText(atual.getNumero());
			lbl_historico_box_1.setText(atual.getGuiche().getNumero());
		}
		
		posicao = index - 2;
		if(posicao >= 0){
			atual = historico.get(posicao);
			lbl_historico_senha_2.setText(atual.getNumero());
			lbl_historico_box_2.setText(atual.getGuiche().getNumero());
		}
		
		posicao = index - 3;
		if(posicao >= 0){
			atual = historico.get(posicao);
			lbl_historico_senha_3.setText(atual.getNumero());
			lbl_historico_box_3.setText(atual.getGuiche().getNumero());
		}
	}
}
