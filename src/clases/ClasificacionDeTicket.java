package clases;

public class ClasificacionDeTicket {

	private Integer idClasificacion;
	private String nombre;
	private String descripcion;
	private EstadoClasificacion estado;
	
	
	public ClasificacionDeTicket() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdClasificacion() {
		return idClasificacion;
	}


	public void setIdClasificacion(Integer idClasificacion) {
		this.idClasificacion = idClasificacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public EstadoClasificacion getEstado() {
		return estado;
	}


	public void setEstado(EstadoClasificacion estado) {
		this.estado = estado;
	}

	
}
