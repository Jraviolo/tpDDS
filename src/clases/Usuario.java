package clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name="IdUsuario")
	private Integer idUsuario;
	
	@Column(name="NombreUsuario")
	private String usuario;
	
	@Column(name="Contrasena")
	private String contraseña;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="legajo")
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


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
