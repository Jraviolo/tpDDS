package gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import clases.CambioClasificacion;
import clases.ClasificacionDeTicket;
import clases.Usuario;

public class GestorClasificacionDeTicket {
	
	public GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public GestorClasificacionDeTicket() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CambioClasificacion newCambioClasificacion(ClasificacionDeTicket c, Usuario u) {
		CambioClasificacion cc=new CambioClasificacion(c,u);
		return cc;
	}
	
	public ArrayList<ClasificacionDeTicket> getClasificaciones() {
		//https://stackoverflow.com/questions/31884775/create-enumeration-of-objects
		//ArrayList<ClasificacionDeTicket> clasificaciones = gbd.getClasificaciones();
		/*ArrayList<ClasificacionDeTicket> clasificaciones=new ArrayList<>(); 
		ClasificacionDeTicket c=new ClasificacionDeTicket();
		c.setIdClasificacion(123);
		c.setNombre("Deudor");
		
		clasificaciones.add(c);
		
		ClasificacionDeTicket c1=new ClasificacionDeTicket();
		c1.setIdClasificacion(345);
		c1.setNombre("Es alto down");
		
		clasificaciones.add(c1);*/
		
		return gbd.getClasificaciones();
	}
	
	public void agregarClasificacion() {
		
	}
	
	public void eliminarClasificacion() {
		
	}
	
	public void buscarClasificacionTickets() {
		
	}
	
	public void modificarClasificacion() {
		
	}

	
}
