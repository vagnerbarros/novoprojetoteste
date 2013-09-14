package masterfila.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "usuario")
public class Usuario implements Entidade{

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa")
	private Estabelecimento empresa;
	
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 20, nullable = false)
	private String cpf;
	
	@Column(name = "login", length = 20, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 50, nullable = false)
	private String senha;
	
	@Column(name = "telefone", length = 20, nullable = true)
	private String telefone;
	
	@Column(name = "rua", length = 100, nullable = false)
	private String rua;
	
	@Column(name = "numero", length = 10, nullable = true)
	private String numero;
	
	@Column(name = "bairro", length = 50, nullable = true)
	private String bairro;
	
	@Column(name = "cidade", length = 30, nullable = true)
	private String cidade;
	
	@Column(name = "estado", length = 30, nullable = true)
	private String estado;
	
	@Column(name = "cep", length = 15, nullable = true)
	private String cep;
	
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Estabelecimento getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Estabelecimento empresa) {
		this.empresa = empresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Object[] getColunas() {
		return null;
	}
}
