package masterfila.desktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import masterfila.dominio.Perfil;
import masterfila.util.Sessao;

public class ViewPrincipal extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JImagePanel imageBg;
	private JMenu mnSistema;
	private JMenu mnCadastro;
	private JMenu mnFuncionrios;
	private JMenu mnTiposDeAtendimento;
	private JMenu mnBoxDeAtendimento;
	private JMenu mnAtendimento;
	private JMenuItem mIncluirFuncionario;
	private JMenuItem mListagemFuncionario;
	private JMenuItem mListarAtendimento;
	private JMenuItem mIncluirTipoAtendimento;
	private JMenuItem mListarBox;
	private JMenuItem mIncluirBox;
	private JMenuItem mntmRealizarAtendimento;
	private JMenuItem mntmSair;
	private JMenuItem mntmMudarUsurio;
//	private JMenuItem mntmSolicitar;
	
	public ViewPrincipal() throws IOException {
		setTitle("Master Fila - Sistema Inteligente de Gerenciamento de Filas de Atendimento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/icon_sistemaHQ.png")));
		initComponents();
	}
	
	private static BufferedImage loadImage(URL url) throws IOException {
		return ImageIO.read(url);
	}	
	
	private void initComponents() throws IOException{
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		imageBg = new JImagePanel(loadImage(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/bg.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(6, 129, 185));
		
		JLabel lblDesenvolvidoPorLeafsoftware = new JLabel("Desenvolvido por LeafSoftware \u00A9 2013 - Todos os direitos reservados");
		lblDesenvolvidoPorLeafsoftware.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesenvolvidoPorLeafsoftware.setForeground(Color.WHITE);
		panel.add(lblDesenvolvidoPorLeafsoftware);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(imageBg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(imageBg, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		imageBg.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/logoHQ.png")));
		imageBg.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-700)/2, (screenSize.height-550)/2, 700, 513);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		mntmMudarUsurio = new JMenuItem("Mudar Usu\u00E1rio");
		mntmMudarUsurio.addActionListener(this);
		mnSistema.add(mntmMudarUsurio);
		
		JSeparator separator = new JSeparator();
		mnSistema.add(separator);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this);
		mnSistema.add(mntmSair);
		
		JSeparator separator_1 = new JSeparator();
		mnSistema.add(separator_1);
		
		mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mnFuncionrios = new JMenu("Funcion\u00E1rios");
		mnCadastro.add(mnFuncionrios);
		
		mIncluirFuncionario = new JMenuItem("Incluir");
		mIncluirFuncionario.addActionListener(this);
		mIncluirFuncionario.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/add.png")));
		mnFuncionrios.add(mIncluirFuncionario);
		
		mListagemFuncionario = new JMenuItem("Listagem/Edi\u00E7\u00E3o");
		mListagemFuncionario.addActionListener(this);
		mListagemFuncionario.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/list.png")));
		mnFuncionrios.add(mListagemFuncionario);
		
		mnTiposDeAtendimento = new JMenu("Tipos de Atendimento");
		mnCadastro.add(mnTiposDeAtendimento);
		
		mIncluirTipoAtendimento = new JMenuItem("Incluir");
		mIncluirTipoAtendimento.addActionListener(this);
		mIncluirTipoAtendimento.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/add.png")));
		mnTiposDeAtendimento.add(mIncluirTipoAtendimento);
		
		mListarAtendimento = new JMenuItem("Listagem        ");
		mListarAtendimento.addActionListener(this);
		mListarAtendimento.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/list.png")));
		mnTiposDeAtendimento.add(mListarAtendimento);
		
		mnBoxDeAtendimento = new JMenu("Box de Atendimento");
		mnBoxDeAtendimento.setIcon(null);
		mnCadastro.add(mnBoxDeAtendimento);
		
		mIncluirBox = new JMenuItem("Incluir");
		mIncluirBox.addActionListener(this);
		mIncluirBox.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/add.png")));
		mnBoxDeAtendimento.add(mIncluirBox);
		
		mListarBox = new JMenuItem("Listagem        ");
		mListarBox.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/list.png")));
		mnBoxDeAtendimento.add(mListarBox);
		mListarBox.addActionListener(this);
		
		mnAtendimento = new JMenu("Atendimento");
		menuBar.add(mnAtendimento);
		
		mntmRealizarAtendimento = new JMenuItem("Realizar Atendimento");
		mntmRealizarAtendimento.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/icon_atendimento.png")));
		mntmRealizarAtendimento.addActionListener(this);
		mnAtendimento.add(mntmRealizarAtendimento);
		
		
//		JMenu mnSolicitarFicha = new JMenu("Solicitar Ficha");
//		menuBar.add(mnSolicitarFicha);
//		mntmSolicitar = new JMenuItem("Solicitar");
//		mntmSolicitar.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/masterfila/desktop/view/img/add.png")));
//		mntmSolicitar.addActionListener(this);
//		mnSolicitarFicha.add(mntmSolicitar);
		
		setExtendedState(MAXIMIZED_BOTH);
		
		definirPerfilAcesso();
	}

	//este método irá inativar os menus que o funcionário comum não pode utilizar
	private void definirPerfilAcesso() {
		if(Sessao.getFuncionario().getPerfil().equals(Perfil.FUNCIONARIO)){
			mnCadastro.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(mntmRealizarAtendimento)){
			DialogRealizarAtendimento d = new DialogRealizarAtendimento();
			d.setVisible(true);
		}
// removido para ser executado separadamente.
//		else if(elemento.equals(mntmSolicitar)){
//			DialogSolicitarFicha d = new DialogSolicitarFicha();
//			d.setVisible(true);
//		}
		if(elemento.equals(mIncluirBox)){
			DialogIncluirBox d = new DialogIncluirBox();
			d.setVisible(true);
		}
		if(elemento.equals(mListarBox)){
			DialogListagemBox d = new DialogListagemBox();
			d.setVisible(true);
		}
		if(elemento.equals(mIncluirTipoAtendimento)){
			DialogIncluirTipoDeAtendimento d = new DialogIncluirTipoDeAtendimento();
			d.setVisible(true);
		}
		if(elemento.equals(mListarAtendimento)){
			DialogListagemTiposAtendimento d = new DialogListagemTiposAtendimento();
			d.setVisible(true);
		}
		if(elemento.equals(mIncluirFuncionario)){
			DialogCadastroFuncionario d = new DialogCadastroFuncionario();
			d.setTabPrincipal(0);
			d.setVisible(true);
		}
		if(elemento.equals(mListagemFuncionario)){
			DialogCadastroFuncionario d = new DialogCadastroFuncionario();
			d.setTabPrincipal(1);
			d.setVisible(true);
		}
		if(elemento.equals(mntmSair)){
			System.exit(0);
		}
		if(elemento.equals(mntmMudarUsurio)){
			try {
				DialogLogin d = new DialogLogin();
				d.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			} finally{
				this.dispose();
			}
		}
	}
}
