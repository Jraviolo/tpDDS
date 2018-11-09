package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="clasificacion")
public class ClasificacionDeTicket {

	@Id
	@Column(name="IDclasif")
	private Integer idClasificacion;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	//INCONSISTENCIA ENTRE BD Y DIAGRAMA DE CLASES
	@Column(name="activo")
	private boolean estado;
	//private EstadoClasificacion estado;
	
	
	//@OneToMany(mappedBy = "clasificacionActual", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToMany (mappedBy="clasificacionActual",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@OneToMany(mappedBy="clasificacionActual")
	public List<Ticket> tickets = new ArrayList<>();
	
	
	//private Usuario usuario;
	
	
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
