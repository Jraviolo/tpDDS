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
}
