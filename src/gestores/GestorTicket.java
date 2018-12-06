package gestores;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import clasesAuxiliares.CambioEstadoAux;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;
import clasesAuxiliares.TicketAux;
import pantallas.CU2_ConsultarT;

public class GestorTicket {

	private GestorBaseDeDatos gbd = new GestorBaseDeDatos();
	private GestorIntervenciones gi = new GestorIntervenciones();
	private GestorClasificacionDeTicket gc=new GestorClasificacionDeTicket();
	private GestorGrupoDeResolucion ggr = new GestorGrupoDeResolucion();
	
	
	public GestorTicket() {
		// TODO Auto-generated constructor stub
	}
	
	public int registrarTicket(int legajo,int idClasificacion,String Descripcion,int idUsuario,int idgrupo,Date fecha) {
		
		ClasificacionDeTicket clasificacion= gbd.buscarClasificacion(idClasificacion);
		GrupoDeResolucion mesaDeAyuda=gbd.buscarGrupo(idgrupo);
	
		Usuario usuario=gbd.buscarUsuario(idUsuario);
		Empleado empleado=gbd.buscarEmpleado(legajo);
		
		EstadoTicket t_abiertoSinDerivar=gbd.buscarEstadoTicket(0);
		EstadoIntervencion i_trabajando=gbd.buscarEstadoIntervencion(3);
		
		
		CambioEstado e1=new CambioEstado(t_abiertoSinDerivar,usuario);
		e1.setFechaInicio(fecha);
		
		CambioClasificacion cc = gc.newCambioClasificacion(clasificacion, usuario);
		cc.setFechaInicio(fecha);
		
		Intervencion i = gi.crearIntervencion(i_trabajando,mesaDeAyuda,usuario,fecha);
		
		Ticket t=new Ticket(empleado,clasificacion,Descripcion,e1,cc,i);
		t.setFechaDeApertura(fecha);
		//t.setId(123);
		
		//esto bd
		int id = gbd.registrarTicket(t);
		System.out.println("-ID DEL TICKET:"+id);
		return id;
		//retornar idticket*/
	}	
	public ArrayList<TicketAux> consultarTicket(Integer nroT,Integer nroL,ClasificacionAux clasificacion,String estado, Date fechaApertura, Date fechaUltCambio, GrupoDeResolucionAux ultGrupo) {
		ArrayList<Ticket> busqueda = gbd.buscarTicket(nroT, nroL, clasificacion, estado, fechaApertura, fechaUltCambio, ultGrupo);
		ArrayList<TicketAux> listaResultado = new ArrayList<TicketAux>();

		for(int i=0;i<busqueda.size();i++) {
			Ticket t= busqueda.get(i);
			TicketAux aux = new TicketAux();
			GrupoDeResolucionAux grupo = new GrupoDeResolucionAux(t.ultimaIntervencion().getGrupo().getNombre(), t.ultimaIntervencion().getGrupo().getCodigo());
			ClasificacionAux clasif = new ClasificacionAux(t.getClasificacionActual().getNombre(),t.getClasificacionActual().getIdClasificacion());
			aux.setIdTicket(t.getId());
			aux.setLegajo(t.getEmpleado().getLegajo());
			aux.setFechaApertura(t.getFechaDeApertura());
			aux.setFechaUltCambio(t.getFechaUltCambio());
			aux.setNombreUsuario(t.getUsuarioCreador().getUsuario());
			aux.setClasificacion(clasif);
			aux.setEstadoActual(t.getEstadoActual().getEstado().getEstado());
			aux.setGrupoActual(grupo);
			aux.setDescripcion(t.getDescripcion());
			listaResultado.add(aux);
		}

		return listaResultado;
	}
	
	public void cerrarTicket(int idTicket,String obs,int idU,int idG) {
		
		Ticket t = gbd.buscarTicket(idTicket);
		Usuario u=gbd.buscarUsuario(idU);
		
		EstadoTicket t_cerrado=gbd.buscarEstadoTicket(3);
		EstadoIntervencion i_terminada=gbd.buscarEstadoIntervencion(2);
		
		Date fechacierre=new Date();
		
		CambioEstado e1=new CambioEstado(t_cerrado,u);
		e1.setFechaInicio(fechacierre);
		e1.setFechaFin(fechacierre);
		
		t.setFechaDeCierre(fechacierre);
		t.setEstadoActual(e1);
		
		//chequear
		Intervencion i = t.getIntervencion(idG);
		System.out.println(i.getEstado());
		gi.finalizarIntervencion(i, i_terminada, u, obs,fechacierre);
		int v= gbd.actualizarTicket(t);
		System.out.println(v);
	}
	
	
	
	//METODO DERIVAR - BRUNO
	public void derivarTicket(int idT,int idEstado,int idGr, int idClasificacion, String obs, int idU) {
		Ticket t = gbd.buscarTicket(idT);
		Usuario u=gbd.buscarUsuario(idU);
		GrupoDeResolucion g=gbd.buscarGrupo(idGr);
		
		
		ClasificacionDeTicket c=gbd.buscarClasificacion(idClasificacion);//this
		
		EstadoTicket t_estado=gbd.buscarEstadoTicket(idEstado);
		EstadoIntervencion i_asignada=gbd.buscarEstadoIntervencion(0);
		EstadoIntervencion i_enespera=gbd.buscarEstadoIntervencion(1);
		
		Date fechaderivar=new Date();
		
		CambioEstado e2=new CambioEstado(t_estado,u);
		e2.setFechaInicio(fechaderivar);		
		t.setEstadoActual(e2);
		
		
		// verificamos si hay que cambiar clasificacion
		if (idClasificacion != t.getClasificacionActual().getIdClasificacion()) {

			Date fC = fechaderivar;
			CambioClasificacion cC = gc.newCambioClasificacion(c, u);
			cC.setFechaInicio(fC);
			
			/////////// nota diagrama
			CambioClasificacion uc = t.ultimoCambio();
			uc.setFechaFin(fC);

			t.actualizarClasificacion(cC, c);
			//////////
		}

		ArrayList<Intervencion> list = new ArrayList<Intervencion>();
		list = ggr.tieneEnEspera(t, g, c);
		if (!list.isEmpty()) {

			gi.actualizarIntervencion(list.get(0), i_asignada, u, obs, fechaderivar);

		} else {

			Intervencion in = gi.crearIntervencion(i_asignada, g, u, fechaderivar);
			t.nuevaIntervencion(in);

		}

		int id = gbd.actualizarTicket(t);
	}  

	
	//ALE
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
		
		//EL 1 ES UNA SOLUCION PROVISORIA PARA SIEMPRE COMO TODO LO PROVISORIO
		Intervencion i=t.getIntervencion(1);
		gi.actualizarIntervencion(i, i_enespera, u, obs,fechaderivar);
		t.nuevaIntervencion(i1);
		gbd.actualizarTicket(t);
	}
	
	public ArrayList<EstadoTicket> getEstados() {
		return gbd.getEstados();
	}
	
	public int ultimoIdTicket() {
		return gbd.ultimoIdTicket();
	}
	
	public void ActualizarEstadoI(int idticket,int idIntervencion,int idEstadoIntervencion,int idClasificacion,String obs,int idU,boolean mesa) {
		
		Usuario u=gbd.buscarUsuario(idU);
		EstadoIntervencion i_estado=gbd.buscarEstadoIntervencion(idEstadoIntervencion);
		
		Ticket t=gbd.buscarTicket(idticket);
		Intervencion i= t.getIntervencion2(idIntervencion);
		
		System.out.println("idIntervencion: "+i.getIdIntervencion()+" id estado nuevo"+idEstadoIntervencion);
		
		Date fecha=new Date();
		
		if(idClasificacion!=t.getClasificacionActual().getIdClasificacion()) {
			ClasificacionDeTicket c =gbd.buscarClasificacion(idClasificacion);
			CambioClasificacion cc=gc.newCambioClasificacion(c, u);
			cc.setFechaInicio(fecha);
			CambioClasificacion uc=t.ultimoCambio();
			uc.setFechaFin(fecha);
			t.actualizarClasificacion(cc, c);
		}
		
		gi.actualizarIntervencion(i, i_estado, u, obs, fecha);
		
		if(idEstadoIntervencion!=3) {
			int idEstadoTicket;
			if(idEstadoIntervencion==2 && mesa) {
				idEstadoTicket=0;
			}
			else if(idEstadoIntervencion==2 && !mesa) {
				boolean v=t.intervencionEnEspera();
				if(v)idEstadoTicket=0;
				else idEstadoTicket=2;
			}
			else /*if(idEstadoIntervencion==1)*/ idEstadoTicket=1;
			System.out.println("antes de bucar estado");
			EstadoTicket t_estado=gbd.buscarEstadoTicket(idEstadoTicket);
			System.out.println("ESTADO TICKET:"+t_estado.getEstado()+ "nuemro:"+t_estado.getId());
			CambioEstado ce=new CambioEstado(t_estado,u);
			ce.setFechaInicio(fecha);
			t.setEstadoActual(ce);
			Intervencion i_mesa=t.getIntervencion(1);
			EstadoIntervencion i_asigando=gbd.buscarEstadoIntervencion(0);
			gi.actualizarIntervencion(i_mesa, i_asigando, u, i_mesa.getObservaciones(), fecha);
		}
		gbd.actualizarTicket(t);
	}
	
	public ArrayList<CambioEstadoAux> getEstadosAux(int idticket){
		Ticket t=gbd.buscarTicket(idticket);
		ArrayList<GrupoDeResolucion> grupos=gbd.getGrupos();
		ArrayList<CambioEstadoAux> estadosAux=new ArrayList<CambioEstadoAux>();
		List<CambioEstado> estados=t.getHistorialEstados();
		
		List<CambioClasificacion> cc=t.getCambioClasificacion();
		
		for(CambioEstado e:estados) {
			CambioEstadoAux ea=new CambioEstadoAux();
			ea.setEstado(e.getEstado().getEstado());
			ea.setFechaFin(e.getFechaFin());
			ea.setFechaInicio(e.getFechaInicio());
			ea.setIdCambioEstado(e.getIdCambioEstado());
			ea.setUsuario(e.getInterviene().getUsuario());
			
			for(CambioClasificacion c:cc) {
				if(c.getFechaInicio().equals(ea.getFechaInicio())) {
					ea.setClasificacion(c.getClasificacion().getNombre());
					break;
				}
				else if(c.getFechaInicio().before(ea.getFechaInicio()))
					ea.setClasificacion(c.getClasificacion().getNombre());
					break;
				}
			
			for(GrupoDeResolucion g:grupos) {
				List<Usuario> miembro=g.getUsuarios();
				for(Usuario u:miembro) {
					if(u.getUsuario().equals(ea.getUsuario())) {
						ea.setGrupo(g.getNombre());
						break;
					}
					
				}
			}
			
			estadosAux.add(ea);
			}
			estadosAux.sort((o2,o1) -> o1.getFechaInicio().compareTo(o2.getFechaInicio()));
		return estadosAux;
		
	}
}
