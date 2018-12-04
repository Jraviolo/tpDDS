package clasesAuxiliares;

import java.util.Date;

public class IntervencionAux {

	private Integer idIntervencion;
	private Integer idTicket;
	private Integer legajo;
	private Date fechaApertura;
	private Date fechaAsignacion;
	private ClasificacionAux clasificacion;
	private String estadoTicket;
	private String estadoIntervencion;
	private GrupoDeResolucionAux grupoActual;
	private String observaciones;
	
	public IntervencionAux() {
		
	}

	public Integer getIdIntervencion() {
		return idIntervencion;
	}

	public void setIdIntervencion(Integer idIntervencion) {
		this.idIntervencion = idIntervencion;
	}

	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public ClasificacionAux getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionAux clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getEstadoTicket() {
		return estadoTicket;
	}

	public void setEstadoTicket(String estadoTicket) {
		this.estadoTicket = estadoTicket;
	}

	public String getEstadoIntervencion() {
		return estadoIntervencion;
	}

	public void setEstadoIntervencion(String estadoIntervencion) {
		this.estadoIntervencion = estadoIntervencion;
	}

	public GrupoDeResolucionAux getGrupoActual() {
		return grupoActual;
	}

	public void setGrupoActual(GrupoDeResolucionAux grupoActual) {
		this.grupoActual = grupoActual;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
