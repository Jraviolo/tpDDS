package clases;

import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="intervencion")
public class Intervencion {

	@Id
	@Column(name="IDinterv")
	private Integer idIntervencion;
	//FALTA MAPEAR
	private EstadoIntervencion estado;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	private Time tiempoDeAtencion;
	@Column(name="observacion")
	private String observaciones;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private GrupoDeResolucion intervencion;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Ticket ticket;
	
	private ArrayList<CambioIntervencion> historialIntervencion = new ArrayList<CambioIntervencion>();
	
	public Intervencion() {
		// TODO Auto-generated constructor stub
	}
	
	public Intervencion(EstadoIntervencion e,GrupoDeResolucion g) {
		estado=e;
		intervencion=g;
	}
	
	public void addCambioIntervencion(CambioIntervencion c) {
		this.historialIntervencion.add(c);
	}


	public Integer getIdIntervencion() {
		return idIntervencion;
	}


	public void setIdIntervencion(Integer idIntervencion) {
		this.idIntervencion = idIntervencion;
	}


	public EstadoIntervencion getEstado() {
		return estado;
	}


	public void setEstado(EstadoIntervencion estado) {
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


	public Time getTiempoDeAtencion() {
		return tiempoDeAtencion;
	}


	public void setTiempoDeAtencion(Time tiempoDeAtencion) {
		this.tiempoDeAtencion = tiempoDeAtencion;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void actualizarIntervencion(CambioIntervencion ci,String Obs){
		//this.UltimoEstado().setFechaFinAsignacion(new Date());
		estado=ci.getEstado();
		//fechaFin=Date;
		historialIntervencion.add(ci);
		observaciones=Obs;
	}
	
	public CambioIntervencion UltimoEstado(){
		CambioIntervencion c1=new CambioIntervencion();
		Boolean encontrado=false;
		int i=historialIntervencion.size()-1;
		while(encontrado==false && i>0) {
			if(historialIntervencion.get(i).getFechaFinAsignacion()==null) {
				c1=historialIntervencion.get(i);
				encontrado=true;
			}
		}
		return c1;
	}
}
