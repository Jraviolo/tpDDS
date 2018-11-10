package clases;

import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.util.Date;

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
	
	@ManyToOne
	private GrupoDeResolucion intervencion;
	
	@ManyToOne
	@JoinColumn(name = "numero")
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

	public void finalizarIntervencion(CambioIntervencion ci,String Obs,Date fecha){
		this.UltimoEstado().setFechaFinAsignacion(fecha);
		estado=ci.getEstado();
		fechaFin=fecha;
		historialIntervencion.add(ci);
		observaciones=Obs;
	}
	
	public void actualizarIntervencion(CambioIntervencion ci,String Obs,Date fecha){
		this.UltimoEstado().setFechaFinAsignacion(fecha);
		estado=ci.getEstado();

		historialIntervencion.add(ci);
		observaciones=Obs;
	}
	
	public CambioIntervencion UltimoEstado(){
		CambioIntervencion c1=new CambioIntervencion();
		Boolean encontrado=false;
		int i=historialIntervencion.size()-1;
		while(encontrado==false && i>0) {
			c1=historialIntervencion.get(i);
			if(c1.getFechaFinAsignacion()==null && c1.getEstado().toString()=="trabajando") {
				encontrado=true;
			}
			else c1=null;
		}
		return c1;
	}

	public String getGrupo() {
		return intervencion.getNombre();
	}
}
