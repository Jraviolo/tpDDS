package clases;

import java.sql.Date;

public class CambioIntervencion {
	
	private Integer idCambiosIntervencion;
	private EstadoIntervencion estado;
	private Date fechaInicioAsignacion;
	private Date fechaFinAsignacion;
	private Date fechaInicioAtencion;
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
