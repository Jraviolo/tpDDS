package gestores;

import clases.CambioIntervencion;
import clases.EstadoIntervencion;
import clases.GrupoDeResolucion;
import clases.Intervencion;
import clases.Usuario;

public class gestorIntervenciones {

	public gestorIntervenciones() {
		// TODO Auto-generated constructor stub
	}
	
	public Intervencion crearIntervencion(EstadoIntervencion e,GrupoDeResolucion g,Usuario u) {
		CambioIntervencion ci=new CambioIntervencion(e,u);
		Intervencion i=new Intervencion(e,g);
		i.addCambioIntervencion(ci);
		return i;
	}
	
	public void consultarIntervenciones() {
		
	}
	
	public void modificarComentarios() {
		
	}
	
	public void actualizarEstadoIntervencion() {
		
	}
	
	public void actualizarIntervencion(Intervencion i,EstadoIntervencion e,Usuario u,String obs) {
		CambioIntervencion c1=new CambioIntervencion(e,u);
		i.actualizarIntervencion(c1, obs);
	}

}
