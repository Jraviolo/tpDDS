package clases;

import java.util.Date;
import java.util.List;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha_apertura")
	private Date fechaDeApertura;
	@Column(name = "fechar_cierre")
	private Date fechaDeCierre;

	@OneToOne
	@JoinColumn(name = "idestado_actual")
	private CambioEstado estadoActual;

	@ManyToOne
	@JoinColumn(name = "IDClasif")
	public ClasificacionDeTicket clasificacionActual;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "duenio")
	private Empleado duenio;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "numero")
	private List<CambioEstado> historialEstados = new ArrayList<CambioEstado>();

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "numero")
	private List<CambioClasificacion> cambioClasificacion = new ArrayList<CambioClasificacion>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "numero")
	private List<Intervencion> intervenciones = new ArrayList<Intervencion>();

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(Empleado e, ClasificacionDeTicket c, String des, CambioEstado e1, CambioClasificacion cc,
			Intervencion i) {
		clasificacionActual = c;
		cambioClasificacion.add(cc);
		duenio = e;
		historialEstados.add(e1);
		estadoActual = e1;
		intervenciones.add(i);
		descripcion = des;
	}

	public List<CambioClasificacion> getCambioClasificacion() {
		return cambioClasificacion;
	}

	public void setCambioClasificacion(List<CambioClasificacion> cambioClasificacion) {
		this.cambioClasificacion = cambioClasificacion;
	}

	public void setHistorialEstados(List<CambioEstado> historialEstados) {
		this.historialEstados = historialEstados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * ANTIGUOS public EstadoTicket getEstadoActual() { return estadoActual; }
	 * 
	 * 
	 * public void setEstadoActual(EstadoTicket estadoActual) { this.estadoActual =
	 * estadoActual; }
	 */// NUEVOS:

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
		// para que quede la misma fecha que el nuevo estado
		estadoActual.setFechaFin(estado.getFechaInicio());

		this.historialEstados.add(estado);
		this.estadoActual = estado;
	}

	public void nuevaIntervencion(Intervencion i) {
		this.intervenciones.add(i);
	}

	public Intervencion ultimaIntervencion() {
		Intervencion ultima = intervenciones.get(0);
		for(Intervencion i: intervenciones) {
			if(i.getFechaInicio().compareTo(ultima.getFechaInicio())>0) {
				if(i.getEstado().id!=2) { //Si la intervencion no esta terminada
					ultima=i;
				} else {
					if(!intervencionEnEspera()){
						ultima=i;
					}
				}
			}
		}
		
		return ultima;
		
	}

	
	public Intervencion getIntervencion(int idgrupo) {
		for (int i=0;i<intervenciones.size(); i++) {
			if(intervenciones.get(i).getGrupo().getCodigo()==idgrupo) {
				return intervenciones.get(i);
			}
			
		}
		System.out.println("noooooooo");
		return null;
	}
	
	public Intervencion getIntervencion2(int idintervencion) {
		for (int i=0;i<intervenciones.size(); i++) {
			if(intervenciones.get(i).getIdIntervencion()==idintervencion) {
				return intervenciones.get(i);
			}
			
		}
		return null;
	}
	
	public boolean intervencionEnEspera() {
		for(Intervencion i: intervenciones) {
			if(i.getEstado().getId()==1)return true;
		}
		return false;
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

	/*
	 * public Time getTiempoDeAtencion() { return tiempoDeAtencion; }
	 * 
	 * 
	 * public void setTiempoDeAtencion(Time tiempoDeAtencion) {
	 * this.tiempoDeAtencion = tiempoDeAtencion; }
	 */

	public Empleado getEmpleado() {
		return duenio;
	}

	public ClasificacionDeTicket getClasificacionActual() {
		return clasificacionActual;
	}

	public Date getFechaUltCambio() {
		return estadoActual.getFechaInicio();
	}

	public Usuario getUsuarioCreador() {
		return intervenciones.get(0).getHistorialIntervencion().get(0).getUsuario();
	}

	public CambioClasificacion ultimoCambio() {
		return this.cambioClasificacion.get(cambioClasificacion.size() - 1);

	}

	public void actualizarClasificacion(CambioClasificacion cc, ClasificacionDeTicket c) {

		this.cambioClasificacion.add(cc);
		this.clasificacionActual = c;

	}

	public List<Intervencion> getIntervenciones() {
		return this.intervenciones;
	}

}
