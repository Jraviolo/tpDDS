package clases;

import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	
	
	@OneToOne
	@JoinColumn(name = "idestado_actual")
	private CambioEstado estadoActual;
	
	@ManyToOne
	public ClasificacionDeTicket clasificacionActual;
	
	@ManyToOne
	private Empleado duenio;
	
	
	@OneToMany(mappedBy="ticket")
	private List<CambioEstado> historialEstados = new ArrayList<CambioEstado>();
	
    @OneToMany(mappedBy="ticket")
	private List<CambioClasificacion> cambioClasificacion = new ArrayList<CambioClasificacion>(); 
	
	@OneToMany(mappedBy="ticket")
	private List<Intervencion> intervenciones = new ArrayList<Intervencion>();
	
	
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

	

	public List<CambioEstado> getHistorialEstados() {
		return historialEstados;
	}

	public void setHistorialEstados(ArrayList<CambioEstado> historialEstados) {
		this.historialEstados = historialEstados;
	}

	public void setEstadoActual(CambioEstado estado) {
		//para que quede la misma fecha que el nuevo estado
		estadoActual.setFechaFin(estado.getFechaInicio());
		
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




	/*public Time getTiempoDeAtencion() {
		return tiempoDeAtencion;
	}


	public void setTiempoDeAtencion(Time tiempoDeAtencion) {
		this.tiempoDeAtencion = tiempoDeAtencion;
	}*/

	public Empleado getEmpleado() {
		return duenio;
	}
	
	public ClasificacionDeTicket getClasificacionActual() {
		return clasificacionActual;
	}

	public Date getFechaUltCambio() {
		return estadoActual.getFechaInicio();
	}
	
	public String getUsuarioCreador(){
		return null;
	}
	
}
