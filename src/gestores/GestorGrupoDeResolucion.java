package gestores;

import java.util.ArrayList;

import clases.ClasificacionDeTicket;
import clases.GrupoDeResolucion;
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
}
