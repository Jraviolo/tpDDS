package pantallas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import clasesAuxiliares.IntervencionAux;


public class ConsultarIntTableModel extends AbstractTableModel{
	
	private List<IntervencionAux> intervenciones = new ArrayList<IntervencionAux>();
	private String[] columnas = {"Numero ticket","Numero legajo","Clasificacion actual", "Estado ticket","Fecha apertura","Hora apertura", "Estado intervención", "Fecha asignación intervención", "Grupo de resolucion actual","Observaciones intervención"};
	
	
	@Override
	public String getColumnName(int indice) {
		return this.columnas[indice];
	}


	@Override
	public int getRowCount() {
		return intervenciones.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object valor = null;
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
		switch (columnIndex) {
		
		case 0:
			valor = this.intervenciones.get(rowIndex).getIdTicket();
			break;
		case 1:
			valor = this.intervenciones.get(rowIndex).getLegajo();
			break;
		case 2:
			valor = this.intervenciones.get(rowIndex).getClasificacion();
			break;
		case 3:
			valor = this.intervenciones.get(rowIndex).getEstadoTicket();
			break;
		case 4:	
			String fecha = f.format(this.intervenciones.get(rowIndex).getFechaApertura());
			valor = fecha;			
			break;
		case 5:
			String hora = h.format(this.intervenciones.get(rowIndex).getFechaApertura());
			valor = hora;
			break;
		case 6:
			valor = this.intervenciones.get(rowIndex).getEstadoIntervencion();
			break;
		case 7:
			String fecha2 = f.format(this.intervenciones.get(rowIndex).getFechaAsignacion());
			valor = fecha2;
			break;
		case 8:
			valor = this.intervenciones.get(rowIndex).getGrupoActual();
			break;
		case 9:
			valor = this.intervenciones.get(rowIndex).getObservaciones();
			break;
			
		default:
			System.out.println("Indice fuera de rango");
			valor = "S/D";
			break;
		}
		return valor;
	}

	public List<IntervencionAux> getTickets() {
		return intervenciones;
	}

	public void setIntervenciones(ArrayList<IntervencionAux> listaResultado) {
		this.intervenciones = listaResultado;
	}
}