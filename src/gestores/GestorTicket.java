package gestores;


import java.util.Date;

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

		GrupoDeResolucion mesaDeAyuda=gbd.buscarGrupo(idgrupo);
		System.out.println(mesaDeAyuda.getNombre());
	/*
		Usuario usuario=gbd.buscarUsuario(idUsuario);
		
		Empleado empleado=gbd.buscarEmpleado(legajo);
		
		CambioEstado e1=new CambioEstado(EstadoTicket.abiertoSinDerivar,usuario);
		e1.setFechaInicio(fecha);
		
		CambioClasificacion cc = gc.newCambioClasificacion(clasificacion, usuario);
		cc.setFechaInicio(fecha);
		
		Intervencion i = gi.crearIntervencion(EstadoIntervencion.trabajando,mesaDeAyuda,usuario,fecha);
		
		Ticket t=new Ticket(empleado,clasificacion,Descripcion,e1,cc,i);
		t.setFechaDeApertura(fecha);
		
		//esto bd
		gbd.registrarTicket(t);
		
		//retornar idticket*/
	}	
	public void consultarTicket(Integer nroT,Integer nroL,String clasificacion,EstadoTicket estado, Date fechaApertura, Date fechaUltCambio, GrupoDeResolucion ultGrupo) {
		this.panelConsultar.setListaTickets(gbd.buscarTicket(nroT, nroL, clasificacion, estado, fechaApertura, fechaUltCambio, ultGrupo), true);
	}
	
	public void cerrarTicket(int idTicket,String obs,int idU) {
		
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		
		Date fechacierre=new Date();
		
		CambioEstado e1=new CambioEstado(EstadoTicket.cerrado,u);
		e1.setFechaInicio(fechacierre);
		
		t.setEstadoActual(e1);
		
		//chequear
		Intervencion i = t.ultimaIntervencion();
		
		gi.finalizarIntervencion(i, EstadoIntervencion.terminada, u, obs,fechacierre);
		gbd.actualizarTicket(idTicket, t);
	}
	
	public void derivarTicket(int idTicket,String obs,int idU,int idgrupo) {
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		GrupoDeResolucion g=gbd.buscarGrupo(idgrupo);
		
		Date fechaderivar=new Date();
		
		CambioEstado e2=new CambioEstado(EstadoTicket.abiertoDerivado,u);
		e2.setFechaInicio(fechaderivar);
		
		Intervencion i1 = gi.crearIntervencion(EstadoIntervencion.asignada,g,u,fechaderivar);
		
		t.setEstadoActual(e2);
		
		//ojota
		Intervencion i=t.ultimaIntervencion();
		gi.actualizarIntervencion(i, EstadoIntervencion.enEspera, u, obs,fechaderivar);
		t.nuevaIntervencion(i1);
		gbd.actualizarTicket(idTicket, t);
	}
	
	public int ultimoIdTicket() {
		return gbd.ultimoIdTicket();
	}
	
	
}
