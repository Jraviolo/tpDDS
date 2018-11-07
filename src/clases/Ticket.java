package clases;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@Column(name="numero")
	private Integer id;

	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fecha_apertura")
	private Date fechaDeApertura;
	@Column(name="fecha_cierre")
	private Date fechaDeCierre;

	//TIEMPO DE ATENCION NO SE GUARDA EN BD? -JOSE
	private Time tiempoDeAtencion;
	
	private CambioEstado estadoActual;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ClasificacionDeTicket clasificacionActual;
	private Empleado duenio;
	private ArrayList<CambioEstado> historialEstados = new ArrayList<CambioEstado>();
	private ArrayList<CambioClasificacion> cambioClasificacion = new ArrayList<CambioClasificacion>();
	private ArrayList<Intervencion> intervenciones = new ArrayList<Intervencion>();
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(Empleado e,ClasificacionDeTicket c,String des,CambioEstado e1,CambioClasificacion cc, Intervencion i) {
		clasificacionActual=c;
		cambioClasificacion.add(cc);
		duenio=e;
		historialEstados.add(e1);
		estadoActual=e1;
		intervenciones.add(i);
		descripcion=des;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

/*ANTIGUOS
	public EstadoTicket getEstadoActual() {
		return estadoActual;
	}


	public void setEstadoActual(EstadoTicket estadoActual) {
		this.estadoActual = estadoActual;
	}
*///NUEVOS:
	
	public CambioEstado getEstadoActual() {
		return estadoActual;
	}


	public void setEstadoActual(CambioEstado estado) {
		//nose como hacerlo con sql date para la fecha actual
		//estadoActual.setFechaFin(new Date());
		this.historialEstados.add(estado);
		this.estadoActual = estado;
	}
	
	public void nuevaIntervencion(Intervencion i) {
		this.intervenciones.add(i);
	}
	
	public Intervencion ultimaIntervencion() {
		
		return null;
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




	public Time getTiempoDeAtencion() {
		return tiempoDeAtencion;
	}


	public void setTiempoDeAtencion(Time tiempoDeAtencion) {
		this.tiempoDeAtencion = tiempoDeAtencion;
	}

	public Empleado getEmpleado() {
		return duenio;
	}
	
	public ClasificacionDeTicket getClasificacionActual() {
		return clasificacionActual;
	}
	
}
