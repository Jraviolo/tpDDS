package clases;

import java.sql.Date;

public class CambioEstado {

	private Integer idCambioEstado;
	private EstadoTicket estado;
	private Date fechaInicio;
	private Date fechaFin;
	private Usuario interviene; //@ale agregue este 
	
	public CambioEstado() {
		// TODO Auto-generated constructor stub
	}
	
	//ale creo este
	public CambioEstado(EstadoTicket e,Usuario u) {
		interviene=u;
		estado=e;
		// TODO Auto-generated constructor stub
	}

	
	public Integer getIdCambioEstado() {
		return idCambioEstado;
	}

	public void setIdCambioEstado(Integer idCambioEstado) {
		this.idCambioEstado = idCambioEstado;
	}

	public EstadoTicket getEstado() {
		return estado;
	}

	public void setEstado(EstadoTicket estado) {
		this.estado = estado;
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

	
}
