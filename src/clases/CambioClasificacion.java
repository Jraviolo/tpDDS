package clases;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="cambio_clasificacion")
public class CambioClasificacion {
	
	@Id
	@Column(name="IDCambios_clasif")
	private Integer idCambioClasificacion;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	//TIEMPO NO SE GUARDA EN BD?
	private Time tiempo;
	
	private Usuario interviene;
	
	private ClasificacionDeTicket clasificacion;
	
	@ManyToOne
	private Ticket ticket;
	
	
	public CambioClasificacion() {
		// TODO Auto-generated constructor stub
	}
	
	public CambioClasificacion(ClasificacionDeTicket c, Usuario u) {
		interviene=u;
		clasificacion=c;
	}
	
	
	public Integer getIdCambioClasificacion() {
		return idCambioClasificacion;
	}


	public void setIdCambioClasificacion(Integer idCambioClasificacion) {
		this.idCambioClasificacion = idCambioClasificacion;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Time getTiempo() {
		return tiempo;
	}


	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}




}
