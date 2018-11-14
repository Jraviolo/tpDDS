package gestores;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

import clases.ClasificacionDeTicket;
import clases.Empleado;
import clases.EstadoIntervencion;
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
		//crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClasificacionDeTicket.class).buildSessionFactory();

		//crear sesión

		Session session = factory.getCurrentSession();
		
		//usar el objeto session

		session.beginTransaction();
		ClasificacionDeTicket c=session.get(ClasificacionDeTicket.class, idclasificacion);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return c;
	
		}
	
	
	public GrupoDeResolucion buscarGrupo(int idgrupo)  {
		
			//crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(GrupoDeResolucion.class).buildSessionFactory();

		//crear sesión

		Session session = factory.getCurrentSession();
		//usar el objeto session
		session.beginTransaction();
		GrupoDeResolucion g=session.get(GrupoDeResolucion.class, idgrupo);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return g;
		}
		
	
	public Usuario buscarUsuario(int idusuario) {
		return null;
	}
	
	public Empleado buscarEmpleado(int legajo) {
		return null;
	}
	
	public EstadoTicket buscarEstadoTicket(int idEstado) {
		return null;
	}
	
	public EstadoIntervencion buscarEstadoIntervencion(int idEstado) {
		return null;
	}
	
	public int registrarTicket(Ticket t) {
		return 0;
		/*	//crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).buildSessionFactory();

		//crear sesión

		Session session = factory.getCurrentSession();
		
		//usar el objeto session
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return t.getId();/*/

	}
	
	public ArrayList<Ticket> buscarTicket(Integer nroT,Integer nroL,String clasificacion,EstadoTicket estado, Date fechaApertura, Date fechaUltCambio, GrupoDeResolucion ultGrupo) {	
		return null;
	}
	
public Ticket buscarTicket(int idTicket) {
	return null;	
	/*
SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).buildSessionFactory();

//crear sesión

Session session = factory.getCurrentSession();
//usar el objeto session

session.beginTransaction();
Ticket t=session.get(Ticket.class, idTicket);
session.getTransaction().commit();
session.close();

factory.close();
return t;/*/
}

	
	public int actualizarTicket(int idticket,Ticket t) {
		return idticket;
		/*	//crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).buildSessionFactory();

		//crear sesión

		Session session = factory.getCurrentSession();
		
		//usar el objeto session
		session.beginTransaction();
		session.saveOrUpdate(t);
		session.getTransaction().commit();
		session.close();
		
		factory.close();
		return t.getId();/*/

	}
	
	public int ultimoIdTicket() {
		/*	//crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).buildSessionFactory();

		//crear sesión

		Session session = factory.getCurrentSession();
		
		//usar el objeto session
		session.beginTransaction();
		int idTicket=
		(int) session.createQuery("select max(Id) as id from Ticket").uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		factory.close();
		return idTicket;/*/
		return 1;
		}
	}

