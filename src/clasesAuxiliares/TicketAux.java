package clasesAuxiliares;

import java.util.Date;

public class TicketAux {
	
	private Integer idTicket;
	private Integer legajo;
	private Date fechaApertura;
	private Date fechaUltCambio;
	private String nombreUsuario;
	private String clasificacion;
	private String estadoActual;
	private GrupoDeResolucionAux grupoActual;
	private String descripcion;
	
	public TicketAux() {
	}
	
	public TicketAux(Integer idTicket, Integer legajo, Date fechaApertura, Date fechaUltCambio, String nombreUsuario,
			String clasificacion, String estadoActual, GrupoDeResolucionAux grupoActual, String descripcion) {
		this.idTicket = idTicket;
		this.legajo = legajo;
		this.fechaApertura = fechaApertura;
		this.fechaUltCambio = fechaUltCambio;
		this.nombreUsuario = nombreUsuario;
		this.clasificacion = clasificacion;
		this.estadoActual = estadoActual;
		this.grupoActual = grupoActual;
		this.descripcion = descripcion;
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
	public Date getFechaUltCambio() {
		return fechaUltCambio;
	}
	public void setFechaUltCambio(Date fechaUltCambio) {
		this.fechaUltCambio = fechaUltCambio;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
	public GrupoDeResolucionAux getGrupoActual() {
		return grupoActual;
	}
	public void setGrupoActual(GrupoDeResolucionAux grupoActual) {
		this.grupoActual = grupoActual;
	}

	public void setDescripcion(String des) {
		this.descripcion=des;
		
	}
	public String getDescripcion() {
		return descripcion;
	}

}
