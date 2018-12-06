package clases;

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

@Entity
@Table(name="cambio_estado")
public class CambioEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDcambios_est")
	private Integer idCambioEstado;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name="IDEst")
	private EstadoTicket estado;
	//private et es;
		//@Transient
	
	
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	
	@ManyToOne
	@JoinColumn(name = "IdUsuario")
	private Usuario interviene; 
	
	public Usuario getInterviene() {
		return interviene;
	}


	public void setInterviene(Usuario interviene) {
		this.interviene = interviene;
	}


	public CambioEstado() {
		// TODO Auto-generated constructor stub
	}
	
	
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
