package clases;

import java.sql.Date;
import java.sql.Time;

public class Ticket {

	private Integer id;
	private EstadoTicket estadoActual;
	private String descripcion;
	private Date fechaDeApertura;
	private Date fechaDeCierre;
	private String numero;
	private Time tiempoDeAtencion;
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

}
