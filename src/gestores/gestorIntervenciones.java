package gestores;

import java.util.Date;

import clases.CambioIntervencion;
import clases.EstadoIntervencion;
import clases.GrupoDeResolucion;
import clases.Intervencion;
import clases.Usuario;

public class gestorIntervenciones {

	public gestorIntervenciones() {
		// TODO Auto-generated constructor stub
	}
	
	public Intervencion crearIntervencion(EstadoIntervencion e,GrupoDeResolucion g,Usuario u,Date fechainicio) {
		CambioIntervencion ci=new CambioIntervencion(e,u);
		ci.setFechaInicioAsignacion(fechainicio);
		
		Intervencion i=new Intervencion(e,g);
		i.setFechaInicio(fechainicio);
		
		i.addCambioIntervencion(ci);
		return i;
	}
	
	public void consultarIntervenciones() {
		
	}
	
	public void modificarComentarios() {
		
	}
	
	public void actualizarEstadoIntervencion() {
		
	}
	
	public void finalizarIntervencion(Intervencion i,EstadoIntervencion e,Usuario u,String obs,Date fecha) {
		CambioIntervencion c1=new CambioIntervencion(e,u);
		c1.setFechaInicioAsignacion(fecha);
		
		i.finalizarIntervencion(c1, obs,fecha);
	}
	
	public void actualizarIntervencion(Intervencion i,EstadoIntervencion e,Usuario u,String obs,Date fecha) {
		CambioIntervencion c1=new CambioIntervencion(e,u);
		c1.setFechaInicioAsignacion(fecha);
		
		i.actualizarIntervencion(c1, obs,fecha);
	}

}
