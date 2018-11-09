package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_ticket")
public class et {
	@Id
	@Column(name="IDEst")
	int id;
	@Column(name="Nombre")
	String estado;
}
