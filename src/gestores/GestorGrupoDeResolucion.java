package gestores;

import java.util.ArrayList;

import clases.ClasificacionDeTicket;
import clases.GrupoDeResolucion;
import clases.Intervencion;
import clases.Ticket;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;

public class GestorGrupoDeResolucion {

	private GestorBaseDeDatos gbd = new GestorBaseDeDatos();

	public GestorGrupoDeResolucion() {
		// TODO Auto-generated constructor stub
	}

	public void agregarGrupo() {

	}

	public void eliminarGrupo() {

	}

	public void buscarGrupo() {

	}

	public void modificarGrupo() {

	}

	public ArrayList<GrupoDeResolucionAux> getGruposAux() {
		ArrayList<GrupoDeResolucion> g = gbd.getGrupos();
		ArrayList<GrupoDeResolucionAux> r = new ArrayList<GrupoDeResolucionAux>();
		for (int i = 0; i < g.size(); i++) {
			int id = g.get(i).getCodigo();
			String nombre = g.get(i).getNombre();
			GrupoDeResolucionAux a = new GrupoDeResolucionAux(nombre, id);
			r.add(a);
		}
		return r;
	}

	public ArrayList<Intervencion> tieneEnEspera(Ticket t, GrupoDeResolucion gr, ClasificacionDeTicket ct) {
		ArrayList<Intervencion> list=new ArrayList<Intervencion>();

			if ( gr.getClasificaciones().contains(ct)) { 
		for (Intervencion i: t.getIntervenciones()) {
		if (i.getEstado().getId()==1)
		list.add(i);	
			
		}	

				return list;

		}	
			return list;
		}

	public ArrayList<ClasificacionAux> getClasificacionesAux(GrupoDeResolucionAux grupoActual) {
		GrupoDeResolucion grupo = gbd.buscarGrupo(grupoActual.getId());
		ArrayList<ClasificacionDeTicket> clasificaciones = (ArrayList<ClasificacionDeTicket>) grupo.getClasificaciones();
		ArrayList<ClasificacionAux> listaResultado = new ArrayList<ClasificacionAux>();
		for(ClasificacionDeTicket c: clasificaciones) {
			ClasificacionAux a=new ClasificacionAux(c.getNombre(),c.getIdClasificacion());
			listaResultado.add(a);
		}
	return listaResultado;
	}

	public GrupoDeResolucionAux getGrupo(ClasificacionAux clasificacion) {
		
		//GrupoDeResolucion grupo = gbd.buscarClasificacion(clasificacion.getId());
		//GrupoDeResolucionAux a = new GrupoDeResolucionAux(grupo.getNombre(),grupo.getCodigo());		
		return null;
	}	

}
