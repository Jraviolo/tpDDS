package clases;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cambio_intervencion")
public class CambioIntervencion {
	
	@Id
	@Column(name="IDcambios_interv")
	private Integer idCambiosIntervencion;
	
	@ManyToOne
	@JoinColumn(name = "IDestado_interv")
	private EstadoIntervencion estado;
	
	@Column(name="fecha_inicio_asig")
	private Date fechaInicioAsignacion;
	
	@Column(name="fecha_fin_asig")
	private Date fechaFinAsignacion;
	
	@Column(name="fecha_inicio_atenc")
	private Date fechaInicioAtencion;
	
	
	@ManyToOne
	@JoinColumn(name = "IdUsuario")
	private Usuario interviene;
	
	

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