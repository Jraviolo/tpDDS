package gestores;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	
	public ArrayList<ClasificacionDeTicket> getClasificaciones() {

		//crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClasificacionDeTicket.class).buildSessionFactory();

		//crear sesión

		Session session = factory.getCurrentSession();

		//usar el objeto session
		session.beginTransaction();
		ArrayList<ClasificacionDeTicket> clasificaciones=
		(ArrayList<ClasificacionDeTicket>) session.createQuery("from ClasificacionDeTicket").getResultList();
		session.getTransaction().commit();
		session.close();
		factory.close();
		return clasificaciones;
	
		

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
	
	public int ultimoIdTicket() {
		//Busca en la base de datos el ultimo id
		return 123456;
	}
}
