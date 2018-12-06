package clasesAuxiliares;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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


public class CambioEstadoAux {

	

	private Integer idCambioEstado;
	private String estado;
	private Date fechaInicio;
	private Date fechaFin;
	private String usuario;
	private String clasificacion;
	private String grupo;
	private String observaciones;
	
	public CambioEstadoAux() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCambioEstado() {
		return idCambioEstado;
	}

	public void setIdCambioEstado(Integer idCambioEstado) {
		this.idCambioEstado = idCambioEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String interviene) {
		this.usuario = interviene;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	@Override
	public String toString() {
		return "CambioEstadoAux [idCambioEstado=" + idCambioEstado + ", estado=" + estado + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", usuario=" + usuario + ", clasificacion=" + clasificacion
				+ ", grupo=" + grupo + ", observaciones=" + observaciones + "]";
	}
}
