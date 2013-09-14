package masterfila.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tipo_ficha")
public class TipoFicha implements Entidade{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "status", length = 10, nullable = false)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Object[] getColunas() {
		return new Object [] {this};
	}
	
	public String toString(){
		return nome;
	}
	
	public boolean equals(Object o){
		if(this.id == ((TipoFicha)o).getId()){
			return true;
		}
		else{
			return false;
		}
	}
}
