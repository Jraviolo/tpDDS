package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_intervencion")
public class EstadoIntervencion {
	@Id
	@GeneratedValue
	@Column(name="IDestado_interv")
	int id;
	@Column(name="nombre")
	String estado;
	
	
	public EstadoIntervencion() {
		super();
		// TODO Auto-generated constructor stub
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


/*
 * id	nombre
 * -----------
 * 0	asignada
 * 1	en espera
 * 2	Terminada
 * 3	Trabajando
 */