package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="IdUsuario")
	private Integer idUsuario;
	@Column(name="NobmreUsuario")
	private String usuario;
	@Column(name="Contrasena")
	private String contraseña;
	
	
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
