package gestores;

import java.util.ArrayList;
import java.util.Date;

import clases.CambioIntervencion;
import clases.EstadoIntervencion;
import clases.GrupoDeResolucion;
import clases.Intervencion;
import clases.Ticket;
import clases.Usuario;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;
import clasesAuxiliares.IntervencionAux;
import clasesAuxiliares.TicketAux;

public class GestorIntervenciones {
	private GestorBaseDeDatos gbd = new GestorBaseDeDatos();

	public GestorIntervenciones() {
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
	

	public ArrayList<IntervencionAux> consultarIntervenciones(String estado, Date fDesde, Date fHasta, Integer nroT, Integer nroL) {
/*		Integer idEstado;
		if(estado.equals("Asignada")) {
			idEstado=0;
		}else {
			if(estado.equals("En espera")) {
				idEstado=1;
			}else {
				if(estado.equals("Trabajando")) {
					idEstado=2;
				}else {
					if(estado.equals("Terminada")) {
						idEstado=3;
					}else { idEstado=null;
					}
				}
			}
				
		}
*/	
		ArrayList<Intervencion> busqueda = gbd.consultarIntervenciones3(estado, fDesde, fHasta, nroT, nroL);
		ArrayList<IntervencionAux> listaResultado = new ArrayList<IntervencionAux>();
		
		for(Intervencion i: busqueda) {
			Ticket t = gbd.buscarTicketAsociado(i.getIdIntervencion());
			IntervencionAux aux = new IntervencionAux();
	//		GrupoDeResolucionAux grupo = new GrupoDeResolucionAux(t.ultimaIntervencion().getGrupo().getNombre(), t.ultimaIntervencion().getGrupo().getCodigo());
			GrupoDeResolucionAux grupo = new GrupoDeResolucionAux(t.getIntervencion2(i.getIdIntervencion()).getGrupo().getNombre(), t.getIntervencion2(i.getIdIntervencion()).getGrupo().getCodigo());
			ClasificacionAux clasificacion = new ClasificacionAux(t.getClasificacionActual().getNombre(),t.getClasificacionActual().getIdClasificacion());
			aux.setIdIntervencion(i.getIdIntervencion());
			aux.setIdTicket(t.getId());
			aux.setLegajo(t.getEmpleado().getLegajo());
			aux.setClasificacion(clasificacion);
			aux.setEstadoTicket(t.getEstadoActual().getEstado().getEstado());
			aux.setFechaApertura(t.getFechaDeApertura());
			aux.setEstadoIntervencion(i.getEstado().getEstado());
			aux.setFechaAsignacion(i.getFechaInicio());
			aux.setGrupoActual(grupo);
			aux.setObservaciones(i.getObservaciones());
			
			listaResultado.add(aux);
		}

		return listaResultado;
	}

}
