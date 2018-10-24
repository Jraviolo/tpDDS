package gestores;

import clases.EstadoIntervencion;
import clases.GrupoDeResolucion;
import clases.Intervencion;

public class gestorIntervenciones {

	public gestorIntervenciones() {
		// TODO Auto-generated constructor stub
	}
	
	public Intervencion newIntervencion(EstadoIntervencion e,GrupoDeResolucion g) {
		Intervencion i=new Intervencion(e,g);
		return i;
	}
	
	public void consultarIntervenciones() {
		
	}
	
	public void modificarComentarios() {
		
	}
	
	public void actualizarEstadoIntervencion() {
		
	}

}
