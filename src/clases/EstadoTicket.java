package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_ticket")
public class EstadoTicket {
	@Id
	@GeneratedValue
	@Column(name="IDEst")
	int id;
	@Column(name="Nombre")
	String estado;
	
	public EstadoTicket() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
