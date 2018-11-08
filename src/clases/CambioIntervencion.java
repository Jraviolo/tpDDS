package clases;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cambio_intervencion")
public class CambioIntervencion {
	
	@Id
	@Column(name="IDcambios_interv")
	private Integer idCambiosIntervencion;
	//FALTA MAPEAR
	private EstadoIntervencion estado;
	@Column(name="fecha_inicio_asig")
	private Date fechaInicioAsignacion;
	@Column(name="fecha_fin_asig")
	private Date fechaFinAsignacion;
	@Column(name="fecha_inicio_atenc")
	private Date fechaInicioAtencion;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Usuario interviene;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Intervencion intervencion;
	

	public CambioIntervencion() {
		// TODO Auto-generated constructor stub
	}

	public CambioIntervencion(EstadoIntervencion e, Usuario u) {
		this.estado=e;
		//this.fechaInicioAtencion=new Date();
		this.interviene=u;
		
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCambiosIntervencion() {
		return idCambiosIntervencion;
	}

	public void setIdCambiosIntervencion(Integer idCambiosIntervencion) {
		this.idCambiosIntervencion = idCambiosIntervencion;
	}

	public EstadoIntervencion getEstado() {
		return estado;
	}

	public void setEstado(EstadoIntervencion estado) {
		this.estado = estado;
	}

	public Date getFechaInicioAsignacion() {
		return fechaInicioAsignacion;
	}

	public void setFechaInicioAsignacion(Date fechaInicioAsignacion) {
		this.fechaInicioAsignacion = fechaInicioAsignacion;
	}

	public Date getFechaFinAsignacion() {
		return fechaFinAsignacion;
	}

	public void setFechaFinAsignacion(Date fechaFinAsignacion) {
		this.fechaFinAsignacion = fechaFinAsignacion;
	}

	public Date getFechaInicioAtencion() {
		return fechaInicioAtencion;
	}

	public void setFechaInicioAtencion(Date fechaInicioAtencion) {
		this.fechaInicioAtencion = fechaInicioAtencion;
	}

	
	
}
