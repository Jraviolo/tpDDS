package gestores;

import java.util.Date;
import java.util.ArrayList;

import clases.ClasificacionDeTicket;
import clases.Empleado;
import clases.EstadoTicket;
import clases.GrupoDeResolucion;
import clases.Ticket;
import clases.Usuario;

public class GestorBaseDeDatos {
	
	public GestorBaseDeDatos() {
		
	}
	
	public ClasificacionDeTicket buscarClasificacion(int idclasificacion) {
		return null;
	}
	
	public GrupoDeResolucion buscarGrupo(int idgrupo) {
		return null;
	}
	
	public Usuario buscarUsuario(int idusuario) {
		return null;
	}
	
	public Empleado buscarEmpleado(int legajo) {
		return null;
	}
	
	public int registrarTicket(Ticket t) {
		int idticket=0;
		return idticket;
	}
	
	public ArrayList<Ticket> buscarTicket(Integer nroT,Integer nroL,String clasificacion,EstadoTicket estado, Date fechaApertura, Date fechaUltCambio, GrupoDeResolucion ultGrupo) {	
		return null;
	}
	
	public Ticket buscarTicket(int idTicket) {	
		return null;
	}
	
	public int actualizarTicket(int idticket,Ticket t) {
		return idticket;
	}
}
