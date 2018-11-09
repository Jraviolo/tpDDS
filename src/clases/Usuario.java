package clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="IdUsuario")
	private Integer idUsuario;
	
	@Column(name="NombreUsuario")
	private String usuario;
	
	@Column(name="Contrasena")
	private String contrase�a;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Empleado empleado;
	
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	

}
