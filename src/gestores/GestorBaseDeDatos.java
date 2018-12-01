package gestores;

import java.util.Date;

import org.hibernate.Criteria;
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
	
	
	
	public boolean existeLegajo(int legajo){

	//crear factory
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	//crear sesión

	Session session = factory.getCurrentSession();
	//usar el objeto session

	session.beginTransaction();
	Empleado e=session.get(Empleado.class, legajo);
	session.getTransaction().commit();
	session.close();
	factory.close();

	if (e==null){
		return false;
	}
	else{
		return true;
	}
	}

	public ArrayList<ClasificacionDeTicket> getClasificaciones() {

		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClasificacionDeTicket.class).buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();

		// usar el objeto session
		session.beginTransaction();
		ArrayList<ClasificacionDeTicket> clasificaciones = (ArrayList<ClasificacionDeTicket>) session
				.createQuery("from ClasificacionDeTicket").getResultList();
		session.getTransaction().commit();
		session.close();
		factory.close();
		return clasificaciones;

	}

	public ClasificacionDeTicket buscarClasificacion(int idclasificacion) {
		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClasificacionDeTicket.class).buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();

		// usar el objeto session

		session.beginTransaction();
		ClasificacionDeTicket c = session.get(ClasificacionDeTicket.class, idclasificacion);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return c;

	}

	public GrupoDeResolucion buscarGrupo(int idgrupo) {

		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(GrupoDeResolucion.class).buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();
		// usar el objeto session
		session.beginTransaction();
		GrupoDeResolucion g = session.get(GrupoDeResolucion.class, idgrupo);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return g;
	}

	public Usuario buscarUsuario(int idusuario) {
		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class)
				.buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();
		// usar el objeto session
		session.beginTransaction();
		Usuario u = session.get(Usuario.class, idusuario);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return u;
	}

	public Empleado buscarEmpleado(int legajo) {
		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class)
				.buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();
		// usar el objeto session
		session.beginTransaction();
		Empleado u = session.get(Empleado.class, legajo);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return u;
	}

	public EstadoTicket buscarEstadoTicket(int idEstado) {
		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(EstadoTicket.class).buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();
		// usar el objeto session
		session.beginTransaction();
		EstadoTicket u = session.get(EstadoTicket.class, idEstado);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return u;
	}

	public EstadoIntervencion buscarEstadoIntervencion(int idEstado) {
		// crear factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(EstadoIntervencion.class).buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();
		// usar el objeto session
		session.beginTransaction();
		EstadoIntervencion u = session.get(EstadoIntervencion.class, idEstado);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return u;
	}

	public int registrarTicket(Ticket t) {
		// crear factory

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		// crear sesión
		Session session = sf.openSession();

		// usar el objeto session

		session.beginTransaction();

		int idt = (int) session.save(t);

		session.getTransaction().commit();
		session.close();
		sf.close();

		return idt;
		/*
		 * //crear factory
		 * 
		 * SessionFactory factory = new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class
		 * ).buildSessionFactory();
		 * 
		 * //crear sesión
		 * 
		 * Session session = factory.getCurrentSession();
		 * 
		 * //usar el objeto session session.beginTransaction(); session.save(t);
		 * session.getTransaction().commit(); session.close(); factory.close(); return
		 * t.getId();/
		 */

	}

	public ArrayList<Ticket> buscarTicket(Integer nroT, Integer nroL, String clasificacion, EstadoTicket estado,
			Date fechaApertura, Date fechaUltCambio, GrupoDeResolucion ultGrupo) {

		// crear objeto factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class)
				.buildSessionFactory();

		// crear sesión

		Session session = factory.getCurrentSession();

		// usar el objeto session
		session.beginTransaction();
		ArrayList<Ticket> tickets = (ArrayList<Ticket>) session.createQuery("from Ticket").getResultList();

		session.getTransaction().commit();
		session.close();

		factory.close();

		Ticket T1 = new Ticket();
		ArrayList<Ticket> L2 = new ArrayList<Ticket>();
		ArrayList<Ticket> L3 = new ArrayList<Ticket>();
		ArrayList<Ticket> L4 = new ArrayList<Ticket>();
		ArrayList<Ticket> L5 = new ArrayList<Ticket>();
		ArrayList<Ticket> L6 = new ArrayList<Ticket>();
		ArrayList<Ticket> L7 = new ArrayList<Ticket>();
		ArrayList<Ticket> listaResultado = new ArrayList<Ticket>();
		Boolean idTicket = false;

		if (nroT != null) {
			int i = tickets.size();
			while (idTicket == false && i >= 0) {
				if (tickets.get(i).getId() == nroT) {
					T1 = buscarTicket(nroT);
					idTicket=true;
				}
				i--;
			}
		}

		if (nroL != null) {
			L2 = buscarTicketPorLegajo(nroL);
		} else {
			L2 = tickets;
		}

		if (clasificacion != null) {
			L3 = buscarTicketPorClasificacion(clasificacion);
		} else {
			L3 = tickets;
		}

		if (estado != null) {
			L4 = buscarTicketPorEstado(estado);
		} else {
			L4 = tickets;
		}

		if (fechaApertura != null) {
			L5 = buscarTicketPorFechaApertura(fechaApertura);
		} else {
			L5 = tickets;
		}

		if (fechaUltCambio != null) {
			L6 = buscarTicketPorFechaUltCambio(fechaUltCambio);
		} else {
			L6 = tickets;
		}

		if (ultGrupo != null) {
			L7 = buscarTicketPorUltGrupo(ultGrupo);
		} else {
			L7 = tickets;
		}

		for (Ticket t : tickets) {

			if (L2.contains(t)) {
				if (L3.contains(t)) {
					if (L4.contains(t)) {
						if (L5.contains(t)) {
							if (L6.contains(t)) {
								if (L7.contains(t)) {
									if (idTicket) {
										if (t.equals(T1)) {
											listaResultado.add(t);
										}
									} else {
										listaResultado.add(t);
									}
								}
							}
						}
					}
				}
			}

		}

		return listaResultado;
	}

	private ArrayList<Ticket> buscarTicketPorUltGrupo(GrupoDeResolucion ultGrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Ticket> buscarTicketPorFechaUltCambio(Date fechaUltCambio) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Ticket> buscarTicketPorFechaApertura(Date fechaApertura) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Ticket> buscarTicketPorEstado(EstadoTicket estado) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Ticket> buscarTicketPorClasificacion(String clasificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Ticket> buscarTicketPorLegajo(Integer nroL) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ticket buscarTicket(int idTicket) {
		return null;
		/*
		 * SessionFactory factory = new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class
		 * ).buildSessionFactory();
		 * 
		 * //crear sesión
		 * 
		 * Session session = factory.getCurrentSession(); //usar el objeto session
		 * 
		 * session.beginTransaction(); Ticket t=session.get(Ticket.class, idTicket);
		 * session.getTransaction().commit(); session.close();
		 * 
		 * factory.close(); return t;/
		 */
	}

	public int actualizarTicket(int idticket, Ticket t) {
		return idticket;
		/*
		 * //crear factory
		 * 
		 * SessionFactory factory = new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class
		 * ).buildSessionFactory();
		 * 
		 * //crear sesión
		 * 
		 * Session session = factory.getCurrentSession();
		 * 
		 * //usar el objeto session session.beginTransaction(); session.saveOrUpdate(t);
		 * session.getTransaction().commit(); session.close();
		 * 
		 * factory.close(); return t.getId();/
		 */

	}

	public int ultimoIdTicket() {
		/*
		 * //crear factory
		 * 
		 * SessionFactory factory = new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class
		 * ).buildSessionFactory();
		 * 
		 * //crear sesión
		 * 
		 * Session session = factory.getCurrentSession();
		 * 
		 * //usar el objeto session session.beginTransaction(); int idTicket= (int)
		 * session.createQuery("select max(Id) as id from Ticket").uniqueResult();
		 * session.getTransaction().commit(); session.close();
		 * 
		 * factory.close(); return idTicket;/
		 */
		return 1;
	}
}
