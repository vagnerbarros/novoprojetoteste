package masterfila.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name = "ficha")
public class Ficha implements Entidade{

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_atendente")
	private Funcionario atendente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private Usuario cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo")
	private TipoFicha tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_guiche")
	private Guiche guiche;
	
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "data", length = 20, nullable = false)
	private Date data;
	
	@Column(name = "chamado", length = 1, nullable = false)
	private String chamado;
	
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Funcionario getAtendente() {
		return atendente;
	}
	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Guiche getGuiche() {
		return guiche;
	}
	public void setGuiche(Guiche guiche) {
		this.guiche = guiche;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setTipo(TipoFicha tipo) {
		this.tipo = tipo;
	}
	public String getChamado() {
		return chamado;
	}
	public void setChamado(String chamado) {
		this.chamado = chamado;
	}
	public TipoFicha getTipo() {
		return tipo;
	}
	public Object[] getColunas() {
		return null;
	}
}
