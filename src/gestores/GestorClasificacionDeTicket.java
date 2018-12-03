package gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import clases.CambioClasificacion;
import clases.ClasificacionDeTicket;
import clases.Usuario;
import clasesAuxiliares.ClasificacionAux;

public class GestorClasificacionDeTicket {
	
	public GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public GestorClasificacionDeTicket() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CambioClasificacion newCambioClasificacion(ClasificacionDeTicket c, Usuario u) {
		CambioClasificacion cc=new CambioClasificacion(c,u);
		return cc;
	}
	
	public ArrayList<ClasificacionAux> getClasificacionesAux() {
		ArrayList<ClasificacionDeTicket> c= gbd.getClasificaciones();
		ArrayList<ClasificacionAux> r= new ArrayList<ClasificacionAux>();
		for(int i=0;i<c.size();i++) {
			int id=c.get(i).getIdClasificacion();
			String nombre=c.get(i).getNombre();
			ClasificacionAux a=new ClasificacionAux(nombre,id);
			r.add(a);
		}
		return r;
	}
	
	public void agregarClasificacion() {
		
	}
	
	public void eliminarClasificacion() {
		
	}
	
	public void buscarClasificacionTickets() {
		
	}
	
	public void modificarClasificacion() {
		
	}


	public ArrayList<ClasificacionAux> getClasificacionesAux(String grupoActual) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
