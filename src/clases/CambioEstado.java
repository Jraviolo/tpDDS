package clases;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cambio_estado")
public class CambioEstado {

	@Id
	@Column(name="IDcambios_est")
	private Integer idCambioEstado;
	
	//FALTA MAPEAR
	private EstadoTicket estado;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Ticket ticket;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
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
