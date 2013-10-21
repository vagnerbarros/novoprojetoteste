package masterfila.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "funcionario")
public class Funcionario implements Entidade{

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa")
	private Estabelecimento estabelecimento;
	
	@Column(name = "nome", length = 200, nullable = true)
	private String nome;
	
	@Column(name = "cpf", length = 20, nullable = true)
	private String cpf;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	
	@Column(name = "perfil", length = 50, nullable = true)
	private String perfil;
	
	@Column(name = "login", length = 50, nullable = true)
	private String login;
	
	@Column(name = "senha", length = 50, nullable = true)
	private String senha;
	
	@Column(name = "status", length = 10, nullable = true)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estabelecimento getEmpresa() {
		return estabelecimento;
	}

	public void setEmpresa(Estabelecimento empresa) {
		this.estabelecimento = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object[] getColunas() {
		return new Object [] {this, cpf};
	}
	
	public String toString(){
		return nome;
	}
	
	public boolean equals(Object o){
		if(this.id == ((Funcionario)o).getId()){
			return true;
		}
		else{
			return false;
		}
	}
}
