package masterfila.util;

import javax.swing.JOptionPane;

import masterfila.dominio.Categoria;
import masterfila.dominio.Perfil;
import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Funcionario;
import masterfila.entidade.Usuario;
import masterfila.fachada.Fachada;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {
	
    public static void main (String [] args){
    	try {
    		Configuration cfg = new Configuration();
            cfg.configure();
            SchemaExport se = new SchemaExport(cfg);
            se.create(true, true);
            
            Fachada fachada = Fachada.getInstance();
            
            Estabelecimento e = new Estabelecimento();
            e.setCategoria(Categoria.AGENCIA);
            e.setEmail("empresa@gmail.com");
            e.setNome("Banco do Brasil");
            e.setCidade("Caruaru");
            e.setCnpj("21.544.292/0001-01");
            e.setEndereco("Rua padre miguel");
            e.setEstado("Pernambuco");
            e.setRazao("Banco do Brasil do Brasilllll");
            fachada.cadastroEmpresa().cadastrar(e);
            
            Funcionario f = new Funcionario();
            f.setCpf("050.529.594-60");
            f.setData_nascimento(Data.converterData("10/10/10"));
            f.setEmpresa(e);
            f.setLogin("1");
            f.setNome("Vagner Barros Pereira");
            f.setPerfil(Perfil.GERENTE);
            f.setSenha("1");
            fachada.cadastroFuncionario().cadastrar(f);

            Usuario u = new Usuario();
            u.setNome("Solicitação Local");
            u.setBairro("Bairro");
            u.setCep("CEP");
            u.setCidade("Cidade");
            u.setCpf("CPF");
            u.setEstado("PE");
            u.setLogin("Login");
            u.setSenha("Senha");
            u.setNumero("Numero");
            u.setRua("Rua");
            u.setTelefone("Telefone");
            u.setEmpresa(e);
            fachada.cadastroUsuario().cadastrar(u);
            
            Funcionario f2 = new Funcionario();
            f2.setCpf("758.220.743-24");
            f2.setData_nascimento(Data.converterData("10/10/10"));
            f2.setEmpresa(e);
            f2.setLogin("2");
            f2.setNome("Pl�nio Manoel");
            f2.setPerfil(Perfil.ADMIN);
            f2.setSenha("2");
            fachada.cadastroFuncionario().cadastrar(f2);
            
            JOptionPane.showMessageDialog(null, "O Banco de Dados foi gerado com sucesso!",
            		"Fafica .:. Alerta",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Base de Dados!",
            	"Fafica .:. Alerta",JOptionPane.ERROR_MESSAGE);
		}
    }
}