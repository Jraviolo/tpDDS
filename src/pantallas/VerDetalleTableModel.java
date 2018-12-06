package pantallas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import clasesAuxiliares.CambioEstadoAux;

public class VerDetalleTableModel extends AbstractTableModel{

	
	private List<CambioEstadoAux> cambios = new ArrayList<CambioEstadoAux>();
	private String[] columnas = {"Fecha cambio", "Hora cambio", "Operador", "Estado", "Grupo resoluci\u00F3n", "Observaciones", "Clasificación del ticket"};
	
	
	@Override
	public String getColumnName(int indice) {
		return this.columnas[indice];
	}


	@Override
	public int getRowCount() {
		return cambios.size();
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
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = f.format(this.cambios.get(rowIndex).getFechaInicio());
			valor = fecha;
			break;
		case 1:
			SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
			String hora = h.format(this.cambios.get(rowIndex).getFechaInicio());
			valor = hora;
			break;
		case 2:			
			valor = this.cambios.get(rowIndex).getUsuario();
			break;
		case 3:
	
			valor = this.cambios.get(rowIndex).getEstado();
			break;
		case 4:
			valor = this.cambios.get(rowIndex).getGrupo();
			break;
		case 5:
			valor = this.cambios.get(rowIndex).getObservaciones();
			break;
		case 6:
			valor = this.cambios.get(rowIndex).getClasificacion();
			break;
		default:
			System.out.println("Indice fuera de rango");
			valor = "S/D";
			break;
		}
		return valor;
	}

	public List<CambioEstadoAux> getCambios() {
		return cambios;
	}

	public void setCambios(ArrayList<CambioEstadoAux> listaResultado) {
		this.cambios = listaResultado;
	}
}