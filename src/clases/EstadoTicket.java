package clases;

public enum EstadoTicket {
abiertoSinDerivar ("Abierto sin derivar"), 
abiertoDerivado ("Abierto derivado"),
solucionadoALaEsperaOK("Solucionado a la espera de OK"),
cerrado("Cerrado");

	private String estado;
	private EstadoTicket(String e) {
		this.estado=e;
	}
	public String getEstado() {
		return estado;
	}
}