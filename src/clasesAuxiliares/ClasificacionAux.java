package clasesAuxiliares;

public class ClasificacionAux {
	
	private String nombre;
	private int Id;

	public ClasificacionAux() {
		
	}
	
	public ClasificacionAux(String n,int i) {
		this.nombre=n;
		this.Id=i;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
