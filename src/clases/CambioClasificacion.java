package clases;

import java.sql.Date;
import java.sql.Time;

public class CambioClasificacion {

	private Integer idCambioClasificacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Time tiempo;
	
	
	public CambioClasificacion() {
		// TODO Auto-generated constructor stub
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
