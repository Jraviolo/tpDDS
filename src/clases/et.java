package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_ticket")
public class et {
	@Id
	@GeneratedValue
	@Column(name="IDEst")
	int id;
	@Column(name="Nombre")
	String estado;
}
