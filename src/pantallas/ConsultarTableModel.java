package pantallas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import clases.Ticket;
import clasesAuxiliares.TicketAux;


public class ConsultarTableModel extends AbstractTableModel{
	
	private List<TicketAux> tickets = new ArrayList<TicketAux>();
	private String[] columnas = {"Numero ticket","Numero legajo","Fecha apertura","Hora apertura", "Operador","Clasificacion actual", "Estado actual", "Ultimo cambio de estado", "Grupo de resolucion actual"};
	
	
	@Override
	public String getColumnName(int indice) {
		return this.columnas[indice];
	}


	@Override
	public int getRowCount() {
		return tickets.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object valor = null;
		switch (columnIndex) {
		
		case 0:
			valor = this.tickets.get(rowIndex).getIdTicket();
			break;
		case 1:
			valor = this.tickets.get(rowIndex).getLegajo();
			break;
		case 2:			
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = f.format(this.tickets.get(rowIndex).getFechaApertura());
			valor = fecha;
			break;
		case 3:
			SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
			String hora = h.format(this.tickets.get(rowIndex).getFechaApertura());
			valor = hora;
			break;
		case 4:
			valor = this.tickets.get(rowIndex).getNombreUsuario();
			break;
		case 5:
			valor = this.tickets.get(rowIndex).getClasificacion();
			break;
		case 6:
			valor = this.tickets.get(rowIndex).getEstadoActual();
			break;
		case 7:
			valor = this.tickets.get(rowIndex).getFechaUltCambio();
			break;
		case 8:
			valor = this.tickets.get(rowIndex).getGrupoActual();
			break;
			
		default:
			System.out.println("Indice fuera de rango");
			valor = "S/D";
			break;
		}
		return valor;
	}

	public List<TicketAux> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<TicketAux> listaResultado) {
		this.tickets = listaResultado;
	}
}