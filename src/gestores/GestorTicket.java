package gestores;

import java.sql.Date;
import java.sql.Time;

import clases.CambioClasificacion;
import clases.CambioEstado;
import clases.ClasificacionDeTicket;
import clases.Empleado;
import clases.EstadoIntervencion;
import clases.EstadoTicket;
import clases.GrupoDeResolucion;
import clases.Intervencion;
import clases.Ticket;
import clases.Usuario;
import pantallas.CU2_ConsultarT;

public class GestorTicket {

	private GestorBaseDeDatos gbd = new GestorBaseDeDatos();
	private gestorIntervenciones gi = new gestorIntervenciones();
	private GestorClasificacionDeTicket gc=new GestorClasificacionDeTicket();
	private CU2_ConsultarT panelConsultar;
	
	
	public GestorTicket() {
		// TODO Auto-generated constructor stub
	}
	
	public void registrarTicket(int legajo,int idClasificacion,String Descripcion,int idUsuario,int idgrupo,Date fecha) {
		
		ClasificacionDeTicket clasificacion= gbd.buscarClasificacion(idClasificacion);
		Usuario usuario=gbd.buscarUsuario(idUsuario);
		GrupoDeResolucion mesaDeAyuda=gbd.buscarGrupo(idgrupo);
		Empleado empleado=gbd.buscarEmpleado(legajo);
		
		CambioEstado e1=new CambioEstado(EstadoTicket.abiertoSinDerivar,usuario);
		CambioClasificacion cc = gc.newCambioClasificacion(clasificacion, usuario);
		Intervencion i = gi.crearIntervencion(EstadoIntervencion.trabajando,mesaDeAyuda,usuario);
		Ticket t=new Ticket(empleado,clasificacion,Descripcion,e1,cc,i);
		t.setFechaDeApertura(fecha);
		
		//esto bd
		gbd.registrarTicket(t);
		
		//retornar idticket
	}	
	public void consultarTicket(Integer nroT,Integer nroL,String clasificacion,EstadoTicket estado, Date fechaApertura, Date fechaUltCambio, GrupoDeResolucion ultGrupo) {
		this.panelConsultar.setListaTickets(gbd.buscarTicket(nroT, nroL, clasificacion, estado, fechaApertura, fechaUltCambio, ultGrupo), true);
	}
	
	public void cerrarTicket(int idTicket,String obs,int idU) {
		
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		CambioEstado e1=new CambioEstado(EstadoTicket.cerrado,u);
		t.setEstadoActual(e1);
		Intervencion i = t.ultimaIntervencion();
		gi.actualizarIntervencion(i, EstadoIntervencion.terminada, u, obs);
		gbd.actualizarTicket(idTicket, t);
	}
	
	public void derivarTicket(int idTicket,String obs,int idU,int idgrupo) {
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		GrupoDeResolucion g=gbd.buscarGrupo(idgrupo);
		CambioEstado e2=new CambioEstado(EstadoTicket.abiertoDerivado,u);
		Intervencion i1 = gi.crearIntervencion(EstadoIntervencion.asignada,g,u);
		t.setEstadoActual(e2);
		Intervencion i=t.ultimaIntervencion();
		gi.actualizarIntervencion(i, EstadoIntervencion.enEspera, u, obs);
		t.nuevaIntervencion(i1);
		gbd.actualizarTicket(idTicket, t);
	}
	
	public int ultimoIdTicket() {
		return gbd.ultimoIdTicket();
	}
	
	
}
