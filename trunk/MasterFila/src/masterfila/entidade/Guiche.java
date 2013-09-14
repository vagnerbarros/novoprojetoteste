package masterfila.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name = "guiche")
public class Guiche implements Entidade{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "situacao", length = 20, nullable = false)
	private String situacao;
	
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object[] getColunas() {
		return new Object[] {this, situacao};
	}
	
	public String toString(){
		return numero;
	}
	
	public boolean equals(Object o){
		if(this.id == ((Guiche)o).getId()){
			return true;
		}
		else{
			return false;
		}
	}
}
