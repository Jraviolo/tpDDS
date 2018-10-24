package clases;

import java.sql.Date;
import java.sql.Time;

public class Ticket {

	private Integer id;
	private EstadoTicket estadoActual;
	private String descripcion;
	private Date fechaDeApertura;
	private Date fechaDeCierre;
	private String numero;
	private Time tiempoDeAtencion;
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public EstadoTicket getEstadoActual() {
		return estadoActual;
	}


	public void setEstadoActual(EstadoTicket estadoActual) {
		this.estadoActual = estadoActual;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaDeApertura() {
		return fechaDeApertura;
	}


	public void setFechaDeApertura(Date fechaDeApertura) {
		this.fechaDeApertura = fechaDeApertura;
	}


	public Date getFechaDeCierre() {
		return fechaDeCierre;
	}


	public void setFechaDeCierre(Date fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Time getTiempoDeAtencion() {
		return tiempoDeAtencion;
	}


	public void setTiempoDeAtencion(Time tiempoDeAtencion) {
		this.tiempoDeAtencion = tiempoDeAtencion;
	}

	
}
