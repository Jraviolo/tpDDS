package gestores;

import java.util.ArrayList;
import java.util.List;

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

	public GrupoDeResolucionAux getGrupo(ClasificacionAux c) {
		ClasificacionDeTicket clasificacion = gbd.buscarClasificacion(c.getId());
		ArrayList<GrupoDeResolucion> grupos = gbd.getGrupos();
		GrupoDeResolucionAux a = new GrupoDeResolucionAux();
		
		for(GrupoDeResolucion g: grupos) {
			System.out.println("vuelta: "+a.getNombre());
			if(g.getClasificaciones().contains(clasificacion)) {
				
				a = new GrupoDeResolucionAux(g.getNombre(),g.getCodigo());	
				System.out.println("grupo: "+a.getNombre());
				break;
			}
		}	
		System.out.println("grupo: "+a.getNombre());
		return a;
	}	
	
	
	public GrupoDeResolucionAux getGrupo(int clasif) {
		ArrayList<GrupoDeResolucion> grupos=gbd.getGrupos();
		for(GrupoDeResolucion g: grupos) {
			List<ClasificacionDeTicket> clasificaciones=g.getClasificaciones();
			for(ClasificacionDeTicket c:clasificaciones) {
				if(c.getIdClasificacion()==clasif) {
					GrupoDeResolucionAux a = new GrupoDeResolucionAux(g.getNombre(),g.getCodigo());
					return a;
				}
			}
		}
		return null;
	}	
}
