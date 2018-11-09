package pantallas;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import clases.Ticket;


public class ConsultarTableModel extends AbstractTableModel{
	
	private List<Ticket> tickets;
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
			valor = this.tickets.get(rowIndex).getId();
			break;
		case 1:
			valor = this.tickets.get(rowIndex).getEmpleado().getLegajo();
			break;
		case 2:			
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = f.format(this.tickets.get(rowIndex).getFechaDeApertura());
			valor = fecha;
			break;
		case 3:
			SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
			String hora = h.format(this.tickets.get(rowIndex).getFechaDeApertura());
			valor = hora;
			break;
		case 4:
			//COMENTADO PORQUE NO ESTA EL METODO TODAVIA
			//valor = this.tickets.get(rowIndex).getOperador();
			break;
		case 5:
			valor = this.tickets.get(rowIndex).getClasificacionActual();
			break;
		case 6:
			valor = this.tickets.get(rowIndex).getEstadoActual();
			break;
		case 7:
			//COMENTADO PORQUE NO ESTA EL METODO TODAVIA
			//valor = this.tickets.get(rowIndex).getFechaUltCambio();
			break;
		case 8:
			//COMENTADO PORQUE NO ESTA EL METODO TODAVIA
			//valor = this.tickets.get(rowIndex).getGrupoResolucion();
			break;
			
		default:
			System.out.println("Indice fuera de rango");
			valor = "S/D";
			break;
		}
		return valor;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}