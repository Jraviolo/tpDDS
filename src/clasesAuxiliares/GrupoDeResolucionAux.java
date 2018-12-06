package clasesAuxiliares;

public class GrupoDeResolucionAux {

	
	private String nombre;
	private Integer Id;

	public GrupoDeResolucionAux() {
		
	}
	
	public GrupoDeResolucionAux(String n,Integer i) {
		this.nombre=n;
		this.Id=i;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
