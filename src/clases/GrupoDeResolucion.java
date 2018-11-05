package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grupo_de_resolucion")
public class GrupoDeResolucion {

	@Id
	@Column(name="codigo")
	private String codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="nivel")
	private NivelDeGrupo nivel;
	@Column(name="activo")
	private String estado;
	
	
	public GrupoDeResolucion() {
		// TODO Auto-generated constructor stub
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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


	public NivelDeGrupo getNivel() {
		return nivel;
	}


	public void setNivel(NivelDeGrupo nivel) {
		this.nivel = nivel;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
