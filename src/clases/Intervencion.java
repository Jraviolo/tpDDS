package clases;

import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="intervencion")
public class Intervencion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDinterv")
	private Integer idIntervencion;
	@ManyToOne
	@JoinColumn(name = "IDestado_interv")
	private EstadoIntervencion estado;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	@Transient
	private Time tiempoDeAtencion;
	@Column(name="observacion")
	private String observaciones;
	
	@ManyToOne//(cascade = CascadeType.ALL) ///ale
	@JoinColumn(name = "codigo")
	private GrupoDeResolucion intervencion;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "IDintervencion")
	private List<CambioIntervencion> historialIntervencion = new ArrayList<CambioIntervencion>();
	
	public GrupoDeResolucion getIntervencion() {
		return intervencion;
	}

	public void setIntervencion(GrupoDeResolucion intervencion) {
		this.intervencion = intervencion;
	}

	public List<CambioIntervencion> getHistorialIntervencion() {
		return historialIntervencion;
	}

	public void setHistorialIntervencion(List<CambioIntervencion> historialIntervencion) {
		this.historialIntervencion = historialIntervencion;
	}

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
		for(int i=0;i<historialIntervencion.size();i++) {
			c1=historialIntervencion.get(i);
			if(c1.getFechaFinAsignacion()==null) return c1;
		}
		return null;
	}

	public GrupoDeResolucion getGrupo() {
		return intervencion;
	}
	@Override
	public String toString() {
		String i = ("id: "+idIntervencion);
		return i;
	}
}
