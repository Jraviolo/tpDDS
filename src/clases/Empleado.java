package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {
	@Id
	@Column (name="Legajo")
	private Integer legajo;
	@Column (name="Nombre")
	private String nombre;
	@Column (name="Apellido")
	private String apellido;
	@Column (name="Telefono_interno")
	private Integer telefonoInterno;
	@Column (name="Telefono_directo")
	private Integer telefonoDirecto;
	//UBICACION NO APARECE EN LAS TABLAS? -JOSE
	//@Column (name="Ubicacion")
	private String ubicacion;
	@Column (name="Descripcion_cargo")
	private String descripcionDeCargo;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}


	public Integer getLegajo() {
		return legajo;
	}


	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Integer getTelefonoInterno() {
		return telefonoInterno;
	}


	public void setTelefonoInterno(Integer telefonoInterno) {
		this.telefonoInterno = telefonoInterno;
	}


	public Integer getTelefonoDirecto() {
		return telefonoDirecto;
	}


	public void setTelefonoDirecto(Integer telefonoDirecto) {
		this.telefonoDirecto = telefonoDirecto;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getDescripcionDeCargo() {
		return descripcionDeCargo;
	}


	public void setDescripcionDeCargo(String descripcionDeCargo) {
		this.descripcionDeCargo = descripcionDeCargo;
	}

	
}