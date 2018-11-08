package clases;

import java.util.ArrayList;

import javax.persistence.OneToMany;

public enum EstadoTicket {
abiertoSinDerivar ("Abierto sin derivar"), 
abiertoDerivado ("Abierto derivado"),
solucionadoALaEsperaOK("Solucionado a la espera de OK"),
cerrado("Cerrado");
	
	@OneToMany (mappedBy="estado")
	private ArrayList<CambioEstado> CambiosEstado = new ArrayList<CambioEstado>();
	private String estado;
	private EstadoTicket(String e) {
		this.estado=e;
	}
	public String getEstado() {
		return estado;
	}
}