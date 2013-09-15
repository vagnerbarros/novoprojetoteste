package masterfila.desktop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import masterfila.dominio.Perfil;
import masterfila.entidade.Funcionario;
import masterfila.exception.ConfirmacaoSenhaException;
import masterfila.exception.CpfExistenteException;
import masterfila.exception.LoginExistenteException;
import masterfila.fachada.Fachada;
import masterfila.mascaras.FPasswordField;
import masterfila.mascaras.FTextFieldCpf;
import masterfila.mascaras.FTextFieldNomeComNumeros;
import masterfila.mascaras.FTextFieldNomeProprio;
import masterfila.util.Sessao;
import masterfila.util.Tabela;
import masterfila.util.Validacao;

import com.toedter.calendar.JDateChooser;

public class DialogCadastroFuncionario extends JDialog implements ActionListener, KeyListener, ChangeListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JButton btnCancelar;
	private JButton btnIncluir;
	private JButton btnEditar;
	private JButton btnRemover;
	private Tabela<Funcionario> tabela;
	private JComboBox<String> comboPerfil;
	private JComboBox<String> comboFiltro;
	private JTextField txtFiltro;
	private JTextField txtLogin;
	private FPasswordField txtSenha;
	private FPasswordField txtConfirmarSenha;
	private JTextField txtCpf;
	private JDateChooser txtDataNascimento;
	private JTabbedPane tabbedPanePrincipal;
	private Funcionario atualizacao;
	private Validacao valida;
	
	public void setTabPrincipal(int index){
		tabbedPanePrincipal.setSelectedIndex(index);
	}
	
	public DialogCadastroFuncionario(){
		setTitle("Funcion\u00E1rios | Cadastro");
		setResizable(false);
		initComponents();
	}
	
	private void initComponents(){
		
		setModal(true);
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-800)/2, (screenSize.height-500)/2, 800, 462);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPanePrincipal, GroupLayout.PREFERRED_SIZE, 774, Short.MAX_VALUE)
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPanePrincipal, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPanePrincipal.addTab("Cadastro", null, panel_2, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		btnIncluir = new JButton("  Incluir");
		btnIncluir.addActionListener(this);
		btnIncluir.setIcon(new ImageIcon(DialogCadastroFuncionario.class.getResource("/masterfila/desktop/view/img/ok.png")));
		
		btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(DialogCadastroFuncionario.class.getResource("/masterfila/desktop/view/img/cancel.png")));
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
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(Color.WHITE);
		
		txtNome = new FTextFieldNomeProprio(200);
		txtNome.setColumns(10);
		
		JLabel lblNomeDoBox = new JLabel("* Nome :");
		lblNomeDoBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCpf = new JLabel("* CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtCpf = new FTextFieldCpf();
		txtCpf.setColumns(10);
		
		
		txtDataNascimento = new JDateChooser();
		txtDataNascimento.getDateEditor().setEnabled(false);
		txtDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeDoBox))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoBox)
						.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Acesso ao Sistema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		
		comboPerfil = new JComboBox<String>();
		iniciarCombo();
		
		JLabel lblPerfil = new JLabel("Perfil:");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtLogin = new FTextFieldNomeComNumeros(20);
		txtLogin.setColumns(10);
		
		txtSenha = new FPasswordField(8);
		txtSenha.setColumns(10);
		
		txtConfirmarSenha = new FPasswordField(8);
		txtConfirmarSenha.setColumns(10);
		
		JLabel lblLogin = new JLabel("* Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSenha = new JLabel("* Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblConfirmarSenha = new JLabel("* Confirmar Senha:");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(comboPerfil, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPerfil))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(txtConfirmarSenha, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmarSenha, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPerfil)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmarSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(txtConfirmarSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboPerfil, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		JLabel lblOsCamposMarcados = new JLabel("Os campos marcados com (*) s\u00E3o obrigat\u00F3rios");
		lblOsCamposMarcados.setForeground(Color.RED);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 749, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 749, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOsCamposMarcados, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOsCamposMarcados)
					.addGap(5)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPanePrincipal.addTab("Listagem", null, panel_3, null);
		tabbedPanePrincipal.addChangeListener(this);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Filtrar Listagem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		btnEditar = new JButton("  Editar Selecionado");
		btnEditar.addActionListener(this);
		btnEditar.setIcon(new ImageIcon(DialogCadastroFuncionario.class.getResource("/masterfila/desktop/view/img/edit.png")));
		
		btnRemover = new JButton("  Remover");
		btnRemover.addActionListener(this);
		btnRemover.setIcon(new ImageIcon(DialogCadastroFuncionario.class.getResource("/masterfila/desktop/view/img/cancel.png")));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(474, Short.MAX_VALUE)
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		comboFiltro = new JComboBox<String>();
		comboFiltro.addItem("Nome");
		comboFiltro.addItem("CPF");
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboFiltro, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtFiltro, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboFiltro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtFiltro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		tabela = new Tabela<Funcionario>(new String [] {"Nome", "CPF"});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400);
		tabela.montarTabela(Fachada.getInstance().cadastroFuncionario().listar());
		scrollPane.setViewportView(tabela);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(DialogCadastroFuncionario.class.getResource("/masterfila/desktop/view/img/funcionario.png")));
		
		JLabel lblBoxDeAtendimento = new JLabel("Cadastro / Edi\u00E7\u00E3o / Listagem de Funcion\u00E1rios");
		lblBoxDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPreenchaOsDados = new JLabel("Navegue pela abas abaixo de acordo com sua nescessidade");
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBoxDeAtendimento, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblPreenchaOsDados, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
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
		
		JTextField [] campos = new JTextField[] {txtNome, txtCpf, txtLogin, txtSenha, txtConfirmarSenha};
		valida = new Validacao(campos);
	}
	
	private void iniciarCombo(){
		String [] perfis = Perfil.getPerfilFuncionario();
		for(String perfil : perfis){
			comboPerfil.addItem(perfil);
		}
	}
	
	private void montarTabela(){

		Fachada fachada = Fachada.getInstance();
		String filtro = txtFiltro.getText();
		List<Funcionario> funcionarios = null;

		if(!filtro.equals("")){
			int combo = comboFiltro.getSelectedIndex();
			//busca por nome
			if(combo == 0){
				funcionarios = fachada.cadastroFuncionario().buscarNome(filtro);
			}
			//busca por cpf
			else if(combo == 1){
				funcionarios = fachada.cadastroFuncionario().buscarCpf(filtro);
			}
		}
		else{
			funcionarios = fachada.cadastroFuncionario().listar();
		}

		tabela.montarTabela(funcionarios);
	}
	
	private boolean validar(){
		boolean valido = false;
		
		valida.normalizarBordas();
		valido = valida.verificarCamposPreenchidos();
		
		if(!valido){
			JOptionPane.showMessageDialog(this, "Campos Obrigatórios não Preenchidos");
		}
		
		if(valido){
			if(!Validacao.cpfValido(txtCpf.getText())){
				JOptionPane.showMessageDialog(this, "CPF Inválido");
				valido = false;
			}
		}
		return valido;
	}
	
	private void cadastrar(){
		
		String nome = txtNome.getText();
		String cpf = txtCpf.getText();
		Date dataNascimento = txtDataNascimento.getDate();
		String perfil = (String) comboPerfil.getSelectedItem();
		String login = txtLogin.getText();
		
		@SuppressWarnings("deprecation")
		String senha = txtSenha.getText();
		
		@SuppressWarnings("deprecation")
		String reSenha = txtConfirmarSenha.getText();
		
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastroFuncionario().verificarSenhaConfirmacao(senha, reSenha);

			Funcionario funcionario = new Funcionario();
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setData_nascimento(dataNascimento);
			funcionario.setPerfil(perfil);
			funcionario.setLogin(login);
			funcionario.setSenha(senha);
			funcionario.setEmpresa(Sessao.getEmpresa());
			
			fachada.cadastroFuncionario().cadastrar(funcionario);
			JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso.");
			limparCampos();
		} catch (ConfirmacaoSenhaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (LoginExistenteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (CpfExistenteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void limparCampos(){
		
		txtNome.setText("");
		txtCpf.setText("");
		txtDataNascimento.setDate(null);
		comboPerfil.setSelectedIndex(0);
		txtLogin.setText("");
		txtSenha.setText("");
		txtConfirmarSenha.setText("");
	}
	
	private void editar(){
		
		int linha = tabela.getSelectedRow();

		if(linha != -1){
			atualizacao = (Funcionario) tabela.getModel().getValueAt(linha, 0);
			
			//seleciona a aba cadastro
			tabbedPanePrincipal.setSelectedIndex(0);
			
			txtNome.setText(atualizacao.getNome());
			txtCpf.setText(atualizacao.getCpf());
			txtDataNascimento.setDate(atualizacao.getData_nascimento());
			comboPerfil.setSelectedItem(atualizacao.getPerfil());
			txtLogin.setText(atualizacao.getLogin());
			txtSenha.setText(atualizacao.getSenha());
			txtConfirmarSenha.setText(atualizacao.getSenha());
		}
		else{
			JOptionPane.showMessageDialog(this, "Selecione o usuário para editar.");
		}
	}
	
	private void atualizar(){
		
		String nome = txtNome.getText();
		String cpf = txtCpf.getText();
		Date dataNascimento = txtDataNascimento.getDate();
		String perfil = (String) comboPerfil.getSelectedItem();
		
		@SuppressWarnings("deprecation")
		String senha = txtSenha.getText();
		
		@SuppressWarnings("deprecation")
		String reSenha = txtConfirmarSenha.getText();
		
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastroFuncionario().verificarSenhaConfirmacao(senha, reSenha);

			atualizacao.setNome(nome);
			atualizacao.setCpf(cpf);
			atualizacao.setData_nascimento(dataNascimento);
			atualizacao.setPerfil(perfil);
			atualizacao.setSenha(senha);
			
			fachada.cadastroFuncionario().atualizar(atualizacao);
			JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso.");
			limparCampos();
			btnIncluir.setText("  Incluir");
			txtLogin.setEditable(true);
			txtCpf.setEditable(true);
		} catch (ConfirmacaoSenhaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void remover(){
		
		int linha = tabela.getSelectedRow();

		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Funcionario f = (Funcionario) tabela.getModel().getValueAt(linha, 0);
				Fachada fachada = Fachada.getInstance();
				fachada.cadastroFuncionario().remover(f);
				montarTabela();
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Selecione o usuário para remover.");
		}
	}

	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnIncluir)){
			String tipo = btnIncluir.getText();
			if(tipo.equals("  Incluir")){
				if(validar()){
					cadastrar();
				}
			}
			else{
				if(validar()){
					atualizar();
				}
			}
		}
		else if(elemento.equals(btnCancelar)){
			this.dispose();
		}
		else if(elemento.equals(btnEditar)){
			btnIncluir.setText("  Atualizar");
			txtLogin.setEditable(false);
			txtCpf.setEditable(false);
			editar();
		}
		else if(elemento.equals(btnRemover)){
			remover();
		}
	}

	public void keyReleased(KeyEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(txtFiltro)){
			montarTabela();
		}
	}
	
	public void stateChanged(ChangeEvent evt) {
		JComponent componente = (JComponent) evt.getSource();
		if(componente.equals(tabbedPanePrincipal)){
			if(tabbedPanePrincipal.getSelectedIndex() == 1){
				montarTabela();
				btnIncluir.setText("  Incluir");
				txtLogin.setEditable(true);
				txtCpf.setEditable(true);
			}
			else if(tabbedPanePrincipal.getSelectedIndex() == 0){
				limparCampos();
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
}
