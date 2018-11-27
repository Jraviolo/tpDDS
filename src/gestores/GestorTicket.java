package gestores;


import java.util.ArrayList;
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
import clasesAuxiliares.TicketAux;
import pantallas.CU2_ConsultarT;

public class GestorTicket {

	private GestorBaseDeDatos gbd = new GestorBaseDeDatos();
	private gestorIntervenciones gi = new gestorIntervenciones();
	private GestorClasificacionDeTicket gc=new GestorClasificacionDeTicket();
	
	
	public GestorTicket() {
		// TODO Auto-generated constructor stub
	}
	
	public void registrarTicket(int legajo,int idClasificacion,String Descripcion,int idUsuario,int idgrupo,Date fecha) {
		
		ClasificacionDeTicket clasificacion= gbd.buscarClasificacion(idClasificacion);
		GrupoDeResolucion mesaDeAyuda=gbd.buscarGrupo(idgrupo);
	
		Usuario usuario=gbd.buscarUsuario(idUsuario);
		Empleado empleado=gbd.buscarEmpleado(legajo);
		
		EstadoTicket t_abiertoSinDerivar=gbd.buscarEstadoTicket(0);
		EstadoIntervencion i_trabajando=gbd.buscarEstadoIntervencion(3);

		System.out.println("Nombre Clasificacion:"+clasificacion.getNombre());
		System.out.println("Nombre grupo:"+mesaDeAyuda.getNombre());
		System.out.println("--Usuario:"+usuario.getUsuario());
		System.out.println("--Empleado:"+empleado.getApellido());
		System.out.println("--Estado inter trabajando:"+i_trabajando.getEstado());
		System.out.println("--Estado ticket abierto:"+t_abiertoSinDerivar.getEstado());
		
		
		CambioEstado e1=new CambioEstado(t_abiertoSinDerivar,usuario);
		e1.setFechaInicio(fecha);
		
		CambioClasificacion cc = gc.newCambioClasificacion(clasificacion, usuario);
		cc.setFechaInicio(fecha);
		
		Intervencion i = gi.crearIntervencion(i_trabajando,mesaDeAyuda,usuario,fecha);
		
		Ticket t=new Ticket(empleado,clasificacion,Descripcion,e1,cc,i);
		t.setFechaDeApertura(fecha);
		//t.setId(123);
		
		//esto bd
		System.out.println("-ID DEL TICKET:"+gbd.registrarTicket(t));
		//retornar idticket*/
	}	
	public ArrayList<TicketAux> consultarTicket(Integer nroT,Integer nroL,String clasificacion,EstadoTicket estado, Date fechaApertura, Date fechaUltCambio, GrupoDeResolucion ultGrupo) {
		ArrayList<Ticket> busqueda = gbd.buscarTicket(nroT, nroL, clasificacion, estado, fechaApertura, fechaUltCambio, ultGrupo);
		ArrayList<TicketAux> listaResultado = new ArrayList<TicketAux>();

		for(int i=0;i<busqueda.size();i++) {
			Ticket t= busqueda.get(i);
			TicketAux aux = new TicketAux(t.getId(),t.getEmpleado().getLegajo(),t.getFechaDeApertura(),t.getFechaUltCambio(),t.getUsuarioCreador(),t.clasificacionActual.getNombre(),t.getEstadoActual().toString(),t.ultimaIntervencion().getGrupo());
			listaResultado.add(aux);
		}

		return listaResultado;
	}
	
	public void cerrarTicket(int idTicket,String obs,int idU) {
		
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		
		EstadoTicket t_cerrado=gbd.buscarEstadoTicket(3);
		EstadoIntervencion i_trabajando=gbd.buscarEstadoIntervencion(2);
		
		Date fechacierre=new Date();
		
		CambioEstado e1=new CambioEstado(t_cerrado,u);
		e1.setFechaInicio(fechacierre);
		
		t.setEstadoActual(e1);
		
		//chequear
		Intervencion i = t.ultimaIntervencion();
		
	//	gi.finalizarIntervencion(i, EstadoIntervencion.terminada, u, obs,fechacierre);
		gbd.actualizarTicket(idTicket, t);
	}
	
	public void derivarTicket(int idTicket,String obs,int idU,int idgrupo) {
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		GrupoDeResolucion g=gbd.buscarGrupo(idgrupo);
		
		EstadoTicket t_abiertoDerivado=gbd.buscarEstadoTicket(1);
		EstadoIntervencion i_asignada=gbd.buscarEstadoIntervencion(0);
		EstadoIntervencion i_enespera=gbd.buscarEstadoIntervencion(1);
		
		Date fechaderivar=new Date();
		
		CambioEstado e2=new CambioEstado(t_abiertoDerivado,u);
		e2.setFechaInicio(fechaderivar);
		
		Intervencion i1 = gi.crearIntervencion(i_asignada,g,u,fechaderivar);
		
		t.setEstadoActual(e2);
		
		//ojota
		Intervencion i=t.ultimaIntervencion();
		gi.actualizarIntervencion(i, i_enespera, u, obs,fechaderivar);
		t.nuevaIntervencion(i1);
		gbd.actualizarTicket(idTicket, t);
	}
	
	public int ultimoIdTicket() {
		return gbd.ultimoIdTicket();
	}
	
	
}
