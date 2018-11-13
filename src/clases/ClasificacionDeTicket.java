package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="clasificacion")
public class ClasificacionDeTicket {

	@Id
	@Column(name="IDclasif")
	@GeneratedValue
	private Integer idClasificacion;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	//INCONSISTENCIA ENTRE BD Y DIAGRAMA DE CLASES
	@Column(name="activo")
	private boolean estado;
	
	@Column(name="fecha")
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name="IdUsuario")
	private Usuario usuario;
	
	
	public ClasificacionDeTicket() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdClasificacion() {
		return idClasificacion;
	}


	public void setIdClasificacion(Integer idClasificacion) {
		this.idClasificacion = idClasificacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	
}
