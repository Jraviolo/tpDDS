package clasesAuxiliares;

public class ClasificacionAux {
	
	private String nombre;
	private int Id;

	public ClasificacionAux() {
		
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
